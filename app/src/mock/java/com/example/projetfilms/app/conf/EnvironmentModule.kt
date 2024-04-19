package com.example.projetfilms.app.conf

import android.content.Context
import com.example.data.di.ApiUrl
import com.example.data.mock.MockManager
import com.example.data.mock.MockUrl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object EnvironmentModule {
    @Provides
    @MockUrl
    fun provideMockManager(@ApplicationContext context: Context): String {
        return MockManager().init(context)
    }
    @Module
    @InstallIn(SingletonComponent::class)
    abstract class Declarations{
        @Binds
        @ApiUrl
        abstract fun provideApiUrl(
            @MockUrl mockUrl: String
        ):String

    }
}