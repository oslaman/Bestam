package com.oslaman.bestam.network

import com.oslaman.bestam.network.model.ConvertCurrency
import com.oslaman.bestam.network.model.RatesApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RatesApi {
    @GET("latest")
    suspend fun getExchangeRates(@QueryMap queries: Map<String, String>): Response<ConvertCurrency>
}