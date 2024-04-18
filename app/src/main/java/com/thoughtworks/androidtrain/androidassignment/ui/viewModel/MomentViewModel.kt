package com.thoughtworks.androidtrain.androidassignment.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.thoughtworks.androidtrain.androidassignment.data.dao.Tweet
import com.thoughtworks.androidtrain.androidassignment.data.dao.User
import com.thoughtworks.androidtrain.androidassignment.data.repository.TweetRepository
import com.thoughtworks.androidtrain.androidassignment.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MomentViewModel(
    application: Application,
    private val tweetRepository: TweetRepository,
    private val userRepository: UserRepository
) : AndroidViewModel(application) {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing.asStateFlow()

    var tweets = MutableLiveData<List<Tweet>>()
    var user = MutableLiveData<User?>()

    fun fetchTweets(): MutableLiveData<List<Tweet>> {
        return tweets
    }

    fun pullData() {
        viewModelScope.launch {
            val tweetList = tweetRepository.saveFromRemote()
            tweets.postValue(tweetList)

            val userInfo = userRepository.saveFromRemote()
            user.postValue(userInfo)
        }
    }

    fun refresh(owner: LifecycleOwner) {
        viewModelScope.launch {
            tweets.observe(owner) {
                tweets.postValue(it.subList(0, 5))
            }
            _isRefreshing.emit(false)
        }
    }
}