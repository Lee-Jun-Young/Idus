package com.example.domain.datasource

import com.example.domain.model.Location
import com.example.domain.model.LocationSearch

interface WeatherRemoteDataSource {

    suspend fun getLocationSearch(query: String): LocationSearch

    suspend fun getLocation(woeid: Int): Location
}