package com.panchalamitr.oxforddictionary.di

import android.content.Context
import com.panchalamitr.oxforddictionary.data.local.MovieDao
import com.panchalamitr.oxforddictionary.data.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext appContext: Context): MovieDatabase {
        return MovieDatabase.invoke(appContext)
    }

    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.getMovieDao()
    }


}