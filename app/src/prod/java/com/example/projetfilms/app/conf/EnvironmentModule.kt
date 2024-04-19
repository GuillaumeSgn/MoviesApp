package com.example.projetfilms.app.conf

import com.example.data.di.ApiUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object EnvironmentModule {
    @Provides
    @ApiUrl
    fun provideUrl() = "https://api.themoviedb.org/"

}