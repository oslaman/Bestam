package com.oslaman.bestam.network

import com.oslaman.bestam.network.model.ConvertCurrency
import com.oslaman.bestam.util.Constants.Companion.apikey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RatesApi {
    @GET("latest")
    suspend fun getExchangeRates(@Query("access_key") accessKey: String = apikey, @QueryMap queries: Map<String, String>): Response<ConvertCurrency>
}