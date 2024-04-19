package com.example.data.di

import com.example.data.api.FilmApi
import com.example.data.repository.MovieRepositoryImplem
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module(includes = [DataModule.Declarations::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class Declarations {
        @Binds
        abstract fun bindMovieRepository(
            movieRepositoryImplem: MovieRepositoryImplem
        ): MovieRepository
    }

    @Provides
    @Singleton
    fun provideFilmApi(
        retrofit: Retrofit
    ): FilmApi {
        return retrofit.create(FilmApi::class.java)
    }
}
