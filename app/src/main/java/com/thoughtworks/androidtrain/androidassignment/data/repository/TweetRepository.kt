package com.thoughtworks.androidtrain.androidassignment.data.repository

import androidx.lifecycle.LiveData
import com.thoughtworks.androidtrain.androidassignment.data.api.Api
import com.thoughtworks.androidtrain.androidassignment.data.dao.Tweet
import com.thoughtworks.androidtrain.androidassignment.data.dao.TweetDao

class TweetRepository(private val tweetDao: TweetDao) {

    fun fetchTweets(): LiveData<List<Tweet>> = tweetDao.getAll()

    suspend fun saveFromRemote(): List<Tweet> {
        val tweets = Api.fetchTweets().filter { it.isValid() }
        tweets.forEach(Tweet::generateAndBindId)
        tweetDao.insertAll(tweets)
        return tweets
    }
}