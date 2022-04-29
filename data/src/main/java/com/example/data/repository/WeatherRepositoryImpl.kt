package com.example.data.repository

import com.example.domain.datasource.WeatherRemoteDataSource
import com.example.domain.model.Location
import com.example.domain.model.LocationSearch
import com.example.domain.repository.WeatherRepository
import com.example.domain.usecase.GetLocationSearchUseCase
import com.example.domain.usecase.GetLocationUseCase
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {
    override suspend fun getLocationSearch(query: String): List<LocationSearch> {
        return weatherRemoteDataSource.getLocationSearch(query)
    }

    override suspend fun getLocation(woeid: Int): Location {
        return weatherRemoteDataSource.getLocation(woeid)
    }
}