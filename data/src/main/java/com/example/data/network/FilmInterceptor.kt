package com.example.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class FilmInterceptor@Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
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
        return chain.proceed(newRequest)
    }
}
