package com.example.domain.usecase

import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class GetLocationSearchUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(query: String) = repository.getLocationSearch(query)
}