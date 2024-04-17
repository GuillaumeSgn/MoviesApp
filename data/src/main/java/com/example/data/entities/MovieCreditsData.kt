package com.example.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieCreditsData(
    val id: Int,
    val cast: List<CastingData>
)
