package com.example.projetfilms.fakedata

import com.squareup.moshi.Json

data class Movies(
    @Json(name = "id")
    val movieId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "overview")
    val synopsis: String,
    @Json(name = "vote_average")
    val rating: Int,
    val genre: String,
    val actors: List<Actor>,
    @Json(name = "release_date")
    val date: String,
    val duree: String
) {
    companion object {
        fun fakeMovies() = listOf(
            Movies(
                0,
                "title of the first movie",
                "synopsis ...",
                87,
                "enfants",
                getActors(),
                "20/06/2020",
                "90min"
            ),
            Movies(
                1,
                "title of the second movie",
                "synopsis ...",
                65,
                "enfants",
                getActors(),
                "15/10/2022",
                "120min"
            ),
            Movies(
                2,
                "titre du film 3",
                "synopsis ...",
                70,
                "action",
                getActors(),
                "03/03/2010",
                "80min"
            )
        )
    }
}

fun getMoviesWithGoodRating() = Movies.fakeMovies().filter { it.rating > 70 }
fun getAllMovies() = Movies.fakeMovies()

fun getMovieById(id: Int): Movies? = Movies.fakeMovies().find { it.movieId == id }
