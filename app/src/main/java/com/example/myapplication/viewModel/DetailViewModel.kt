package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Tweet
import com.example.myapplication.repository.TweetyRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val repository: TweetyRepository) : ViewModel() {

    val tweet : StateFlow<List<Tweet>>
        get()  = repository.tweets

    init {

        viewModelScope.launch {
            repository.getTweets("Travel")
        }

    }
}