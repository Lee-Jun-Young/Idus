package com.example.idus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Location
import com.example.domain.usecase.GetLocationSearchUseCase
import com.example.domain.usecase.GetLocationUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getLocationSearchUseCase: GetLocationSearchUseCase,
    private val getLocationUseCase: GetLocationUseCase
) : ViewModel() {

    private val data = mutableListOf<Location>()

    private val _locationData = MutableLiveData<List<Location>>()
    val locationData: LiveData<List<Location>> get() = _locationData

    suspend fun getLocationData() {
        data.clear()
        val locationSearch = getLocationSearchUseCase("se")
        locationSearch.forEach {
            data.add(getLocationUseCase(it.woeid))
        }
        _locationData.value = data
    }

}