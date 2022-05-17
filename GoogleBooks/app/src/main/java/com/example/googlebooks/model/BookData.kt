package com.example.googlebooks.model


import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("items")
    val items: List<Item>
)