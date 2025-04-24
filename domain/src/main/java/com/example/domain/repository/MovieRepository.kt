package com.example.domain.repository

import com.example.domain.model.MovieCredits
import com.example.domain.model.MovieDetails
import com.example.domain.model.MovieGenre
import com.example.domain.model.Results

interface MovieRepository {
    suspend fun getListPopular(): Results

    suspend fun getListNowPlaying(): Results

    suspend fun getListTopRated(): Results

    suspend fun getListUpcoming(): Results

    suspend fun getAllGenres(): MovieGenre

    suspend fun findMovieById(movieId: Int): MovieDetails

    suspend fun getActorsOfMovie(movieId: Int): MovieCredits
}
