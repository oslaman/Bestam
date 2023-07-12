package com.oslaman.bestam.network.model

import com.squareup.moshi.Json

data class ConvertCurrency(
    @Json(name = "base")
    val base: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "rates")
    val rates: Rates
)