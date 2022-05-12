package com.logituit.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.logituit.mvvm.api.QuoteService
import com.logituit.mvvm.models.QuoteList
import com.logituit.mvvm.models.QuoteList1

class QuoteRepository(private val quoteService: QuoteService) {
    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quotesLiveData
    private val quotesLiveData1 = MutableLiveData<QuoteList1>()
    val quotes1: LiveData<QuoteList1>
        get() = quotesLiveData1

    suspend fun getQuotes(api_key: Int) {
        val result = quoteService.getQuotes(api_key)
        if (result.body() != null) {
            quotesLiveData.postValue(result.body())
        }
    }

    suspend fun getQuotes1(api_key: Int) {
        val resultX = quoteService.getQuotes1(api_key)
        if (resultX.body() != null) {
            quotesLiveData1.postValue(resultX.body())
        }
    }

}