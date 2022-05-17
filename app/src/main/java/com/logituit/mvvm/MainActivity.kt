package com.logituit.mvvm

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.logituit.mvvm.api.QuoteService
import com.logituit.mvvm.api.RetrofitHelper
import com.logituit.mvvm.models.QuoteList
import com.logituit.mvvm.models.Result
import com.logituit.mvvm.repository.QuoteRepository
import com.logituit.mvvm.viewmodel.MainViewModel
import com.logituit.mvvm.viewmodel.MainViewModelFactory
import com.logituit.mvvm.viewmodel.Myadapter

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var newRecyclerView: RecyclerView
    lateinit var newArrayList: ArrayList<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.moviesInstance
        val repository = QuoteRepository(quoteService)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this) { Log.d("MAHESH", it.results.toString()) }
        mainViewModel.quotes1.observe(this) { Log.d("AMRAVATI", it.results.toString()) }

        getUserdata()
    }

    private fun getUserdata() {

        newRecyclerView = findViewById(R.id.popularR)
        newRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Result>()
        }
    }