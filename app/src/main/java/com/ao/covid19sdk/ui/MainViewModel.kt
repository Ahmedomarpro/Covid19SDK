package com.ao.covid19sdk.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ao.covid19sdk.model.ApiResponse
import com.ao.covid19sdk.repository.CovidRepository
import com.ao.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainViewModel(private val repository: CovidRepository) : ViewModel() {

    private val _covidLiveData = MutableLiveData<State<ApiResponse>>()

    val covidLiveData: LiveData<State<ApiResponse>>
        get() = _covidLiveData

    fun getData() {
        viewModelScope.launch {
            repository.getData().collect {
                _covidLiveData.value = it
            }
        }
    }
}