package com.oslaman.bestam.network.model

import com.squareup.moshi.Json

data class RatesApiModel(
    @Json(name = "base")
    val base: String, // EUR
    @Json(name = "date")
    val date: String, // 2021-02-26
    @Json(name = "rates")
    val rates: Rates
)