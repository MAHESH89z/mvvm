package com.logituit.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.logituit.mvvm.models.QuoteList
import com.logituit.mvvm.models.QuoteList1
import com.logituit.mvvm.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
            repository.getQuotes1(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
    val quotes1: LiveData<QuoteList1>
        get() = repository.quotes1
}