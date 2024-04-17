package com.example.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultData(
    val page: Int,
    val results: List<MoviesData>
)
