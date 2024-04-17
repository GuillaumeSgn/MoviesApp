package com.example.domain.repository

import com.example.domain.MovieCredits
import com.example.domain.MovieDetails
import com.example.domain.MovieGenre
import com.example.domain.Result

interface MovieRepository {
    suspend fun getListPopular(): Result

    suspend fun getListNowPlaying(): Result

    suspend fun getListTopRated(): Result

    suspend fun getListUpcoming(): Result

    suspend fun getAllGenres(): MovieGenre

    suspend fun findMovieById(movieId: Int): MovieDetails

    suspend fun getActorsOfMovie(movieId: Int): MovieCredits
}