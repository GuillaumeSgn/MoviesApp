package com.example.data.api

import android.util.Log
import com.example.projetfilms.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BaseUrl = "https://api.themoviedb.org/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjOWNlM2YzMjRlM2NlNDQ2NmJmYzIyMDM5YmE4M" +
                    "jE4OSIsInN1YiI6IjY2MTY5MDc0YzdhN2UwMDE2NDA2NzlkZSIsInNjb3BlcyI6WyJhcGlfcmVh" +
                    "ZCJdLCJ2ZXJzaW9uIjoxfQ.tt12wmkdFSGUTHYpo1ALHc1TbXGb49hp2-XYH615k3o"
            )
            .build()
        chain.proceed(newRequest)
    }
    .addNetworkInterceptor(
        HttpLoggingInterceptor {
            Log.v("network", it)
        }.apply { level = HttpLoggingInterceptor.Level.BODY }
    )
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BaseUrl)
    .client(okHttpClient)
    .build()

object FilmApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
