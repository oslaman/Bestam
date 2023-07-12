package com.oslaman.bestam.network

import com.oslaman.bestam.network.model.ConvertCurrency
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val currencyRatesApi: RatesApi) {
    suspend fun getExchangeRates(queries: Map<String, String>): Response<ConvertCurrency> {
        return currencyRatesApi.getExchangeRates(queries)
    }
}