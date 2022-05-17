package com.example.googlebooks.repository

import com.example.googlebooks.model.BookData
import com.example.googlebooks.network.RetrofitClient
import retrofit2.Call

class BookRepository {
    fun getBooks(): Call<BookData> {
        return RetrofitClient.service.getBooks()
    }
}