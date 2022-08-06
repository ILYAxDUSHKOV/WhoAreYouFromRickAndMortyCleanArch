package com.example.whoareyoufromrickandmortycleanarch.di

import com.example.whoareyoufromrickandmortycleanarch.data.remote.MyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRickAndMortyApi(): com.example.whoareyoufromrickandmortycleanarch.data.remote.MyAPI {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}