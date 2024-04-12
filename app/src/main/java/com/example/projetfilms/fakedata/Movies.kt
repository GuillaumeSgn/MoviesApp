package com.example.projetfilms.fakedata

import com.squareup.moshi.Json

data class Movies(
    @Json(name = "id")
    val movieId: Int,
    val title: String,
    @Json(name = "overview")
    val synopsis: String,
    @Json(name = "vote_average")
    val rating: Float,
    @Json(name = "genre_ids")
    val genre: List<Int>,
//    val actors: List<Actor>,
    @Json(name = "poster_path")
    val poster: String,
    @Json(name = "release_date")
    val date: String,
//    val duree: String
) {
    companion object {

    }
}


