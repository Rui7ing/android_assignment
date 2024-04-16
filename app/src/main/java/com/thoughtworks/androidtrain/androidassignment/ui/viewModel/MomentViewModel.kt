package com.thoughtworks.androidtrain.androidassignment.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.thoughtworks.androidtrain.androidassignment.data.dao.Tweet
import com.thoughtworks.androidtrain.androidassignment.data.repository.TweetRepository
import com.thoughtworks.androidtrain.androidassignment.data.repository.UserRepository
import kotlinx.coroutines.launch

class MomentViewModel(
    application: Application,
    private val tweetRepository: TweetRepository,
    private val userRepository: UserRepository
) : AndroidViewModel(application) {

    var tweets = MutableLiveData<List<Tweet>>()

    fun fetchTweets(): MutableLiveData<List<Tweet>> {
        return tweets
    }

    fun pullData() {
        viewModelScope.launch {
            val data = tweetRepository.saveFromRemote()
            tweets.postValue(data)
        }
    }
}