package com.example.data.entities

import com.squareup.moshi.Json

data class MovieDetails(
    val title: String,
    @Json(name = "poster_path")
    val poster: String,
    val overview: String,
    @Json(name = "release_date")
    val date: String,
    val genres: List<Genre>
//    val actors
)
