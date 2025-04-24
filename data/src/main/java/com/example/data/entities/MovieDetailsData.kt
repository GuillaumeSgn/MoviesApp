package com.example.data.entities

import com.example.domain.model.MovieDetails
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

fun MovieDetailsData.mapToDomain() = MovieDetails(
    title = title,
    poster = poster,
    overview = overview,
    date = date,
    genres = genres.map { it.mapToDomain() }
)
