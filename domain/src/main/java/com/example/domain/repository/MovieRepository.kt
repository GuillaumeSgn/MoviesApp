package com.example.domain.repository

import com.example.domain.MovieCredits
import com.example.domain.MovieDetails
import com.example.domain.MovieGenre
import com.example.domain.Results

interface MovieRepository {
    suspend fun getListPopular(): Results

    suspend fun getListNowPlaying(): Results

    suspend fun getListTopRated(): Results

    suspend fun getListUpcoming(): Results

    suspend fun getAllGenres(): MovieGenre

    suspend fun findMovieById(movieId: Int): MovieDetails

    suspend fun getActorsOfMovie(movieId: Int): MovieCredits
}