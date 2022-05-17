package com.example.googlebooks.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.googlebooks.model.BookData
import com.example.googlebooks.model.Item
import com.example.googlebooks.model.VolumeInfo
import com.example.googlebooks.repository.BookRepository
import com.example.googlebooks.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.googlebooks.adapter.BookAdapter

class BookViewModel(private val repository : BookRepository) : ViewModel() {

    //livedata
    var booksList : MutableLiveData<List<Item>> = MutableLiveData()
    //adapter
    var adapter: BookAdapter = BookAdapter()


    @SuppressLint("NotifyDataSetChanged")
    fun setAdapterData(data: List<VolumeInfo>) {
        adapter.setBookList(data)
        adapter.notifyDataSetChanged()
    }


    //통신
    fun makeApiCall() {
        val response = repository.getBooks()
        response.enqueue(object : Callback<BookData> {
            override fun onResponse(call: Call<BookData>, response: Response<BookData>) {
                booksList.postValue(response.body()?.items)
            }

            override fun onFailure(call: Call<BookData>, t: Throwable) {
                Log.d(Constants.TAG, "실패")
            }
        })
    }
}