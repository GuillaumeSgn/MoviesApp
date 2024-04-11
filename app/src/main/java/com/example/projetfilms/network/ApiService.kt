package com.example.projetfilms.network

import com.example.projetfilms.fakedata.Movies
import retrofit2.http.GET


interface ApiService {
    @GET("3/movie/popular")
    suspend fun getListPopular(): List<Movies>

    @GET("3/movie/now_playing")
    suspend fun getListNowPlaying(): List<Movies>

    @GET("3/movie/top_rated")
    suspend fun getListTopRated(): List<Movies>

    @GET("3/movie/upcoming")
    suspend fun getListUpcoming(): List<Movies>
}

