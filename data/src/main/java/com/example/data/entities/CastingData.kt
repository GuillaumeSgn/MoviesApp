package com.example.data.entities

import com.example.domain.Casting
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastingData(
    val name: String,
    @Json(name = "profile_path")
    val picture: String?,
    val character: String,
    @Json(name = "known_for_department")
    val job: String
)

fun CastingData.mapToDomain() = Casting(
    name = name,
    picture = picture.orEmpty(),
    character = character,
    job = job
)
