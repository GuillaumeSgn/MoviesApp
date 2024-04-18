package com.example.data.di

import com.example.data.api.FilmApi
import com.example.data.repository.MovieRepositoryImplem
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Provides
    fun provideFilmApi(
        retrofit: Retrofit
    ): FilmApi {
        return retrofit.create(FilmApi::class.java)
    }

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImplem: MovieRepositoryImplem
    ): MovieRepository
}
