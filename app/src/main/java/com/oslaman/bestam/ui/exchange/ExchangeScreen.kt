package com.oslaman.bestam.ui.exchange

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.oslaman.bestam.R
import com.oslaman.bestam.network.model.Rates
import com.oslaman.bestam.ui.components.NetworkResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen(
    context: Context = LocalContext.current,
    exchangeViewModel: ExchangeViewModel = hiltViewModel()
) {
    val fromCurrencyCode = rememberSaveable{ mutableStateOf("EUR") }
    val toCurrencyCode = rememberSaveable{ mutableStateOf("USD") }
    val exchangeAmount = rememberSaveable{ mutableStateOf("") }

    val convertedAmount = rememberSaveable{ mutableStateOf("") }
    val singleConvertedAmount = rememberSaveable{ mutableStateOf("") }

    val scope = rememberCoroutineScope()
    var isFromSelected: Boolean = true
    
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = {Text(text = stringResource(id = R.string.currency_exchange))} )
        },
        
    ){  paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            Row {
                Column {
                    Text(text = "From")
                    Text(text = fromCurrencyCode.value)
                }
                Column {
                    Text(text = "To")
                    Text(text = toCurrencyCode.value)
                }
            }
            TextField(
                value = exchangeAmount.value,
                onValueChange = { exchangeAmount.value = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    exchangeViewModel.getExchangeRates(provideQueries(fromCurrencyCode.value))
                    exchangeViewModel.exchangeRatesResponse.observe(
                        context as LifecycleOwner
                    ) { response ->
                        when (response) {
                            is NetworkResult.Success -> {
                                response.data?.let {
                                    if (exchangeAmount.value.isEmpty()) {
                                        exchangeAmount.value = "1.00"
                                    }

                                    val toValue = getToValue(toCurrencyCode.value, it.rates)
                                    val ammount = exchangeAmount.value.toDouble()
                                    convertedAmount.value =
                                        "${getOutputString(ammount * toValue)} ${toCurrencyCode.value}"
                                    singleConvertedAmount.value =
                                        "1 ${fromCurrencyCode.value} = ${getOutputString(toValue)} ${toCurrencyCode.value}"
                                }
                            }

                            is NetworkResult.Error -> {
                                Toast.makeText(context, response.message, Toast.LENGTH_SHORT)
                                    .show()
                            }

                            is NetworkResult.Loading -> {
                                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
                })
            )

            Text(
                text = singleConvertedAmount.value,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(textAlign = TextAlign.Center)
            )
        }
    }

}

fun getOutputString(value: Double): String {
    return "%.2f".format(value)
}

fun getToValue(currencyCode: String, rates: Rates): Double {
    return when (currencyCode) {
        "AUD" -> rates.aUD
        "BRL" -> rates.bRL
        "BGN" -> rates.bGN
        "CAD" -> rates.cAD
        "CNY" -> rates.cNY
        "HRK" -> rates.hRK
        "CZK" -> rates.cZK
        "DKK" -> rates.dKK
        "EUR" -> rates.eUR
        "GBP" -> rates.gBP
        "HKD" -> rates.hKD
        "HUF" -> rates.hUF
        "ISK" -> rates.iSK
        "INR" -> rates.iNR
        "IDR" -> rates.iDR
        "ILS" -> rates.iLS
        "JPY" -> rates.jPY
        "KRW" -> rates.kRW
        "MYR" -> rates.mYR
        "MXN" -> rates.mXN
        "NZD" -> rates.nZD
        "NOK" -> rates.nOK
        "PHP" -> rates.pHP
        "PLN" -> rates.pLN
        "RON" -> rates.rON
        "RUB" -> rates.rUB
        "SGD" -> rates.sGD
        "ZAR" -> rates.zAR
        "SEK" -> rates.sEK
        "CHF" -> rates.cHF
        "THB" -> rates.tHB
        "TRY" -> rates.tRY
        "USD" -> rates.uSD
        else -> 0.00
    }
}

fun provideQueries(from: String): HashMap<String, String> {
    val queries = HashMap<String, String>()
    queries["base"] = from
    return queries
}
