package com.example.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("/location/search")
    suspend fun locationSearch(
        @Query("query") query: String
    ): List<LocationSearchDto>

    @GET("/location/{woeid}")
    suspend fun location(
        @Path("woeid") woeid: Int?
    ): LocationDto

}