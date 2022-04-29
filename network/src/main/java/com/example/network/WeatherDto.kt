package com.example.network

import com.google.gson.annotations.SerializedName

data class LocationSearchDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)

data class LocationDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int,
    @SerializedName("consolidated_weather")
    val data: List<ConsolidateDataDto>
)

data class ConsolidateDataDto(
    @SerializedName("weather_state_name")
    val weather_state_name: String,
    @SerializedName("weather_state_abbr")
    val weather_state_abbr: String,
    @SerializedName("the_temp")
    val the_temp: Int,
    @SerializedName("humidity")
    val humidity: Float
)