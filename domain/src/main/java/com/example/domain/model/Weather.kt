package com.example.domain.model

data class LocationSearch(
    val title: String,
    val woeid: Int
)

data class Location(
    val title: String,
    val woeid: Int,
    val data: List<ConsolidateData>
)

data class ConsolidateData(
    val weather_state_name: String,
    val weather_state_abbr: String,
    val the_temp: Double,
    val humidity: Float
)