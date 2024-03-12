package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.repository.TweetyRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val repository: TweetyRepository) : ViewModel() {

    val category : StateFlow<List<String>>
        get()  = repository.category

    init {

        viewModelScope.launch {
            repository.getCategory()
        }

    }
}