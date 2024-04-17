package com.example.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsData(
    val title: String,
    @Json(name = "poster_path")
    val poster: String,
    val overview: String,
    @Json(name = "release_date")
    val date: String,
    val genres: List<GenreData>
)
