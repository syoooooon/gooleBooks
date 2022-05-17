package com.example.googlebooks.network

import com.example.googlebooks.model.BookData
import retrofit2.Call
import retrofit2.http.GET

interface IService {
    @GET("books/v1/volumes?q=kotlin")
    fun getBooks() : Call<BookData>
}