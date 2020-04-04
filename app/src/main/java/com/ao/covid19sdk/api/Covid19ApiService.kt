package com.ao.covid19sdk.api

import com.ao.covid19sdk.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface Covid19ApiService {

       @GET("/data.json")
       suspend  fun getData() : Response<ApiResponse>

       companion object{
              const val BASE_URL = "https://api.covid19india.org/"

       }
}