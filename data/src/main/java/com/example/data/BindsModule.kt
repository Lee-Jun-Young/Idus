package com.example.data

import com.example.data.datasource.WeatherRemoteDataSourceImpl
import com.example.data.repository.WeatherRepositoryImpl
import com.example.domain.datasource.WeatherRemoteDataSource
import com.example.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindsModule {

    @Binds
    abstract fun provideRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    abstract fun provideUserDataSource(weatherRemoteDataSourceImpl: WeatherRemoteDataSourceImpl): WeatherRemoteDataSource

}