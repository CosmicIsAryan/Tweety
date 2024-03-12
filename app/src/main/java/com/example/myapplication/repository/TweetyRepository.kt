package com.example.myapplication.repository

import com.example.myapplication.Tweety
import com.example.myapplication.api.TweetyApi
import com.example.myapplication.models.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetyRepository @Inject constructor(private val tweetyApi: TweetyApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category :StateFlow<List<String>>
        get()= _category


    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets :StateFlow<List<Tweet>>
        get()= _tweets




    suspend fun getCategory(){
        val response = tweetyApi.getCategory()

        if (response != null && response.isSuccessful){
            _category.emit(response.body()!!)

        }
    }
    suspend fun getTweets(category: String){
        val response = tweetyApi.getTweets(category)

        if (response != null && response.isSuccessful){
            _tweets.emit(response.body()!!)

        }
    }
}