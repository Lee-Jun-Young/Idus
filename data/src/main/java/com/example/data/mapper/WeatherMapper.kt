package com.example.data.mapper

import com.example.domain.model.ConsolidateData
import com.example.domain.model.Location
import com.example.domain.model.LocationSearch
import com.example.network.ConsolidateDataDto
import com.example.network.LocationDto
import com.example.network.LocationSearchDto

// LocationSearch
fun LocationSearchDto.toLocationSearch(): LocationSearch =
    LocationSearch(
        title,
        woeid
    )

// Location
fun LocationDto.toLocation(): Location =
    Location(
        title,
        woeid,
        data.map {
            it.toConsolidateData()
        }
    )

fun ConsolidateDataDto.toConsolidateData(): ConsolidateData =
    ConsolidateData(
        weather_state_name,
        weather_state_abbr,
        the_temp,
        humidity
    )