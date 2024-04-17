package com.example.data.entities

import com.example.domain.MovieCredits
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieCreditsData(
    val id: Int,
    val cast: List<CastingData>
)

fun MovieCreditsData.mapToDomain() = MovieCredits(id,cast.map { it.mapToDomain() })
