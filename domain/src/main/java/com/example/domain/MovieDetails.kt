package com.example.domain

data class MovieDetails(
    val title: String,
    val poster: String,
    val overview: String,
    val date: String,
    val genres: List<Genre>
)
