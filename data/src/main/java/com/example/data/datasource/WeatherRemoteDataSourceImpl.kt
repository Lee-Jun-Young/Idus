package com.example.data.datasource

import com.example.data.mapper.toLocation
import com.example.data.mapper.toLocationSearch
import com.example.domain.datasource.WeatherRemoteDataSource
import com.example.domain.model.Location
import com.example.domain.model.LocationSearch
import com.example.network.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(private val weatherService: WeatherService) :
    WeatherRemoteDataSource {
    override suspend fun getLocationSearch(query: String): List<LocationSearch> =
        withContext(Dispatchers.IO) {
            weatherService.locationSearch(query).map {
                it.toLocationSearch()
            }
        }


    override suspend fun getLocation(woeid: Int): Location =
        withContext(Dispatchers.IO) {
            weatherService.location(woeid).toLocation()
        }
}