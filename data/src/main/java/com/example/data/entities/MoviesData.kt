package com.example.data.entities

import com.example.domain.model.Movies
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesData(
    @Json(name = "id")
    val movieId: Int,
    val title: String,
    @Json(name = "overview")
    val synopsis: String,
    @Json(name = "vote_average")
    val rating: Float,
    @Json(name = "genre_ids")
    val genre: List<Int>,
    @Json(name = "poster_path")
    val poster: String,
    @Json(name = "release_date")
    val date: String,
    val isFavorite: Boolean = false
)

fun MoviesData.mapToDomain(): Movies = Movies(
    movieId = movieId,
    title = title,
    synopsis = synopsis,
    rating = rating,
    genre = genre,
    poster = poster,
    date = date,
    isFavorite = isFavorite
)
