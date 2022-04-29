package com.example.domain.repository

import com.example.domain.model.Location
import com.example.domain.model.LocationSearch

interface WeatherRepository {

    suspend fun getLocationSearch(query: String): LocationSearch

    suspend fun getLocation(woeid: Int): Location

}