package com.example.domain

import com.example.projetfilms.network.MovieCredits
import com.example.projetfilms.network.MovieDetails
import com.example.projetfilms.network.MovieGenre
import com.example.projetfilms.network.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("3/movie/popular")
    suspend fun getListPopular(): Result

    @GET("3/movie/now_playing")
    suspend fun getListNowPlaying(): Result

    @GET("3/movie/top_rated")
    suspend fun getListTopRated(): Result

    @GET("3/movie/upcoming")
    suspend fun getListUpcoming(): Result

    @GET("3/genre/movie/list")
    suspend fun getAllGenres(): MovieGenre

    @GET("3/movie/{movie_id}")
    suspend fun findMovieById(@Path("movie_id") movieId: Int): MovieDetails

    @GET("3/movie/{movie_id}/credits")
    suspend fun getActorsOfMovie(@Path("movie_id") movieId: Int): MovieCredits
}
