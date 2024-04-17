package com.thoughtworks.androidtrain.androidassignment.data.api

import com.thoughtworks.androidtrain.androidassignment.data.api.RetrofitBuilder.retrofitTweet
import com.thoughtworks.androidtrain.androidassignment.data.api.RetrofitBuilder.retrofitUser
import com.thoughtworks.androidtrain.androidassignment.data.dao.Tweet
import com.thoughtworks.androidtrain.androidassignment.data.dao.User
import retrofit2.Response
import retrofit2.http.GET

object Api {

    suspend fun fetchTweets(): List<Tweet> {
        return if (retrofitTweet.fetchTweets().isSuccessful) {
            retrofitTweet.fetchTweets().body() ?: emptyList()
        } else { emptyList() }
    }

    suspend fun fetchUsers(): User? {
        return if (retrofitUser.fetchUsers().isSuccessful) {
            retrofitUser.fetchUsers().body()
        } else { null }
    }
}

interface ITweetApi {
    @GET("tweets.json")
    suspend fun fetchTweets(): Response<List<Tweet>>
}

interface IUserApi {
    @GET("user.json")
    suspend fun fetchUsers(): Response<User>
}