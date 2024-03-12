package com.example.myapplication.api

import com.example.myapplication.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetyApi {

    @GET("/v3/b/65efefa11f5677401f3c41ab?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<Tweet>>


    @GET("/v3/b/65efefa11f5677401f3c41ab?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory():Response<List<String>>


}