package com.example.googlebooks

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.adapter.BookAdapter
import com.example.googlebooks.databinding.ActivityMainBinding
import com.example.googlebooks.model.BookData
import com.example.googlebooks.model.VolumeInfo
import com.example.googlebooks.repository.BookRepository
import com.example.googlebooks.utils.Constants
import com.example.googlebooks.viewmodel.BookViewModel
import com.example.googlebooks.viewmodel.BookViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookViewModel: BookViewModel //뷰모델


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //recyclerViewAdapter
        val adapter = BookAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel setUp
        bookViewModel = ViewModelProvider(this, BookViewModelFactory(BookRepository())).get(BookViewModel::class.java)
        bookViewModel.booksList.observe(this, Observer {
            //update adapter
            bookViewModel.setAdapterData(it) //미해결
        })
        bookViewModel.makeApiCall()




    }

}