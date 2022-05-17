package com.example.googlebooks.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)