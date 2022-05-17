package com.example.googlebooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.googlebooks.repository.BookRepository

//https://readystory.tistory.com/176
class BookViewModelFactory constructor(private val repository: BookRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            BookViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}