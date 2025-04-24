package com.example.domain.model

data class Movies(
    val movieId: Int,
    val title: String,
    val synopsis: String,
    val rating: Float,
    val genre: List<Int>,
    val poster: String,
    val date: String,
    val isFavorite: Boolean = false
)
