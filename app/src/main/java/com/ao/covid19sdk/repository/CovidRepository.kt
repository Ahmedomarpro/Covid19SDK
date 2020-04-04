package com.ao.covid19sdk.repository

import com.ao.covid19sdk.api.Covid19ApiService
import com.ao.covid19sdk.model.ApiResponse
import com.ao.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response


class CovidRepository(private val apiService: Covid19ApiService) {

     fun getData(): Flow<State<ApiResponse>> {
        return object : NetworkBoundRepository<ApiResponse>() {
            override suspend fun fetchFromRemote(): Response<ApiResponse> = apiService.getData()
        }.asFlow().flowOn(Dispatchers.IO)
    }
}