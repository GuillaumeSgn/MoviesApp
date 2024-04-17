package com.example.data.api

import com.example.data.entities.MovieCreditsData
import com.example.data.entities.MovieDetailsData
import com.example.data.entities.MovieGenreData
import com.example.data.entities.ResultData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("3/movie/popular")
    suspend fun getListPopular(): ResultData

    @GET("3/movie/now_playing")
    suspend fun getListNowPlaying(): ResultData

    @GET("3/movie/top_rated")
    suspend fun getListTopRated(): ResultData

    @GET("3/movie/upcoming")
    suspend fun getListUpcoming(): ResultData

    @GET("3/genre/movie/list")
    suspend fun getAllGenres(): MovieGenreData

    @GET("3/movie/{movie_id}")
    suspend fun findMovieById(@Path("movie_id") movieId: Int): MovieDetailsData

    @GET("3/movie/{movie_id}/credits")
    suspend fun getActorsOfMovie(@Path("movie_id") movieId: Int): MovieCreditsData
}
