package com.example.data.repository

import com.example.data.api.FilmApi
import com.example.data.entities.mapToDomain
import com.example.domain.model.MovieCredits
import com.example.domain.model.MovieDetails
import com.example.domain.model.MovieGenre
import com.example.domain.model.Results
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplem @Inject constructor(
    private val filmApi: FilmApi
) : MovieRepository {
    override suspend fun getListPopular(): Results {
        return filmApi.getListPopular().mapToDomain()
    }

    override suspend fun getListNowPlaying(): Results {
        return filmApi.getListNowPlaying().mapToDomain()
    }

    override suspend fun getListTopRated(): Results {
        return filmApi.getListTopRated().mapToDomain()
    }

    override suspend fun getListUpcoming(): Results {
        return filmApi.getListUpcoming().mapToDomain()
    }

    override suspend fun getAllGenres(): MovieGenre {
        return filmApi.getAllGenres().mapToDomain()
    }

    override suspend fun findMovieById(movieId: Int): MovieDetails {
        return filmApi.findMovieById(movieId).mapToDomain()
    }

    override suspend fun getActorsOfMovie(movieId: Int): MovieCredits =
        filmApi.getActorsOfMovie(movieId).mapToDomain()
}
