package com.oslaman.bestam.network

import com.oslaman.bestam.network.model.ConvertCurrency
import com.oslaman.bestam.util.Constants.Companion.apikey
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val currencyRatesApi: RatesApi) {
    suspend fun getExchangeRates(queries: Map<String, String>): Response<ConvertCurrency> {
        return currencyRatesApi.getExchangeRates(apikey,queries)
    }
}