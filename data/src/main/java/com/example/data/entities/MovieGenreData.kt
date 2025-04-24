package com.example.data.entities

import com.example.domain.model.MovieGenre
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieGenreData(
    val genres: List<GenreData>
)

fun MovieGenreData.mapToDomain(): MovieGenre = MovieGenre(
    genres = genres.map { it.mapToDomain() }
)
