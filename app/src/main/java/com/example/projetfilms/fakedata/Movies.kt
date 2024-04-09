package com.example.projetfilms.fakedata

data class Movies(
    val movieId: Int,
    val title: String,
    val synopsis: String,
    val rating: Int,
    val genre: String,
    val actors: List<Actor>,
    val date: String,
    val duree: String
) {
    companion object {
        fun fakeMovies() = listOf(
            Movies(0,"title of the first movie", "synopsis ...", 87,"enfants", getActors(),"20/06/2020","90min"),
            Movies(1,"title of the second movie", "synopsis ...", 65,"enfants", getActors(),"15/10/2022","120min"),
            Movies(2,"titre du film 3","synopsis ...",70,"action", getActors(),"03/03/2010","80min")
        )
    }
}
fun getMoviesWithGoodRating() = Movies.fakeMovies().filter { it.rating > 70 }
fun getAllMovies() = Movies.fakeMovies()

fun getMovieById(id:Int): Movies? = Movies.fakeMovies().find { it.movieId == id }
