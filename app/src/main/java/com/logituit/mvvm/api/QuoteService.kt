package com.logituit.mvvm.api


import com.logituit.mvvm.models.QuoteList
import com.logituit.mvvm.models.QuoteList1
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("movie/popular")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

    @GET("movie/upcoming")
    suspend fun getQuotes1(@Query("page") page: Int): Response<QuoteList1>
}
