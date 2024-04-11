package com.example.projetfilms.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


private const val BASE_URL = "https://api.themoviedb.org/"
private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object FilmApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}