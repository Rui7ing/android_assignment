package com.thoughtworks.androidtrain.androidassignment.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.thoughtworks.androidtrain.androidassignment.data.repository.ApplicationDatabase
import com.thoughtworks.androidtrain.androidassignment.data.repository.TweetRepository
import com.thoughtworks.androidtrain.androidassignment.data.repository.UserRepository
import com.thoughtworks.androidtrain.androidassignment.ui.viewModel.MomentViewModel

class MomentActivity : ComponentActivity() {

    private val tweetRepository: TweetRepository by lazy {
        TweetRepository(ApplicationDatabase(application).tweetDao())
    }
    private val userRepository: UserRepository by lazy {
        UserRepository(ApplicationDatabase(application).userDao())
    }
    private val momentViewModel: MomentViewModel by lazy {
        MomentViewModel(application, tweetRepository, userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "MomentActivity")

            momentViewModel.pullData()
            momentViewModel.tweets.observe(this) {
                list -> list.forEach{ println(it.content) }
            }
        }
    }
}