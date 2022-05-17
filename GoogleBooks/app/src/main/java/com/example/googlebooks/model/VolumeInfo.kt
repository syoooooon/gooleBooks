package com.example.googlebooks.model


import com.google.gson.annotations.SerializedName

/**
 * 책 제목
 * 저자
 * 출판사
 * 출판일
 * 상세링크
 * 책 이미지
 */

data class VolumeInfo(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("infoLink")
    val infoLink: String,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("title")
    val title: String
)