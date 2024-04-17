package com.example.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieGenreData(
    val genres: List<GenreData>
)
