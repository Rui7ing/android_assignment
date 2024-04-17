package com.thoughtworks.androidtrain.androidassignment.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TWEET_URL = "https://xianmobilelab.gitlab.io/moments-data/"
private const val User_URL = "https://xianmobilelab.gitlab.io/moments-data/"

object RetrofitBuilder {

    val retrofitTweet: ITweetApi = Retrofit.Builder()
        .baseUrl(TWEET_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ITweetApi::class.java)

    val retrofitUser: IUserApi = Retrofit.Builder()
        .baseUrl(User_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IUserApi::class.java)
}