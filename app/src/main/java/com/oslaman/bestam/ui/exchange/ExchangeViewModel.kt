package com.oslaman.bestam.ui.exchange

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.oslaman.bestam.network.model.ConvertCurrency
import com.oslaman.bestam.repository.ExchangeRepository
import com.oslaman.bestam.ui.components.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val repository: ExchangeRepository,
    application: Application
) : AndroidViewModel(application) {

    var exchangeRatesResponse: MutableLiveData<NetworkResult<ConvertCurrency>> = MutableLiveData()

    fun getExchangeRates(queries: Map<String, String>) {
        viewModelScope.launch {
            getExchangeRatesSafeCall(queries)
        }
    }

    private suspend fun getExchangeRatesSafeCall(queries: Map<String, String>) {
        if (checkInternetConnection()) {
            try {
                val response = repository.remote.getExchangeRates(queries)
                exchangeRatesResponse.value = handleExchangeRatesResponse(response)
            } catch (e: Exception) {
                exchangeRatesResponse.value =
                    NetworkResult.Error(message = "No Response. Try Again!!")
            }
        } else {
            exchangeRatesResponse.value = NetworkResult.Error(message = "No Internet Connection")
        }
    }

    private fun handleExchangeRatesResponse(response: Response<ConvertCurrency>): NetworkResult<ConvertCurrency> {
        return when {
            response.message().toString().contains("timeout") -> {
                NetworkResult.Error(message = "Time Out")
            }
            response.isSuccessful -> {
                val exchangeResponse = response.body()
                NetworkResult.Success(data = exchangeResponse!!)
            }
            else -> {
                NetworkResult.Error(message = "Could Not Fetch Results")
            }
        }
    }

    private fun checkInternetConnection(): Boolean {
        val connectivityManager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }

    }
}