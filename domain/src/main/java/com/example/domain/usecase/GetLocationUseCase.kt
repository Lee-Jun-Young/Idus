package com.example.domain.usecase

import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(woeid: Int) = repository.getLocation(woeid)
}