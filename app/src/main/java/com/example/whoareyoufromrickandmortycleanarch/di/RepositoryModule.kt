package com.example.whoareyoufromrickandmortycleanarch.di

import com.example.whoareyoufromrickandmortycleanarch.data.repository.repositoryImpl
import com.example.whoareyoufromrickandmortycleanarch.domain.repository.repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        repositoryImpl:repositoryImpl
    ):repository
}