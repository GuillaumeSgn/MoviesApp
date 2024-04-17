package com.example.data.repository

import com.example.data.api.FilmApi
import com.example.data.entities.mapToDomain
import com.example.domain.MovieCredits
import com.example.domain.MovieDetails
import com.example.domain.MovieGenre
import com.example.domain.Results
import com.example.domain.repository.MovieRepository

class MovieRepositoryImplem : MovieRepository {
    override suspend fun getListPopular(): Results {
        return FilmApi.retrofitService.getListPopular().mapToDomain()
    }

    override suspend fun getListNowPlaying(): Results {
        return FilmApi.retrofitService.getListNowPlaying().mapToDomain()
    }

    override suspend fun getListTopRated(): Results {
        return FilmApi.retrofitService.getListTopRated().mapToDomain()
    }

    override suspend fun getListUpcoming(): Results {
        return FilmApi.retrofitService.getListUpcoming().mapToDomain()
    }

    override suspend fun getAllGenres(): MovieGenre {
        return FilmApi.retrofitService.getAllGenres().mapToDomain()
    }

    override suspend fun findMovieById(movieId: Int): MovieDetails {
        return FilmApi.retrofitService.findMovieById(movieId).mapToDomain()
    }

    override suspend fun getActorsOfMovie(movieId: Int): MovieCredits =
        FilmApi.retrofitService.getActorsOfMovie(movieId).mapToDomain()
}