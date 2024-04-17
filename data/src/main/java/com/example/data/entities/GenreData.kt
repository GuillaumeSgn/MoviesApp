package com.example.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreData(
    val id: Int,
    val name: String
)
