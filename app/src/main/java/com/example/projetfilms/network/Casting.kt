package com.example.projetfilms.network

import com.squareup.moshi.Json

data class Casting(
    val name: String,
    @Json(name = "profile_path")
    val picture: String,
    val character: String,
    @Json(name ="known_for_department")
    val job: String
)
