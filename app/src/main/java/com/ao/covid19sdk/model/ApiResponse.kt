package com.ao.covid19sdk.model

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "statewise")
    val stateWiseDetails: List<TotalDetails>
)