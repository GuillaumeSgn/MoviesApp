package com.example.data.entities

import com.example.domain.Genre
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreData(
    val id: Int,
    val name: String
)

fun GenreData.mapToDomain(): Genre = Genre(
    id = id,
    name = name
)
