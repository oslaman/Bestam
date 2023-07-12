package com.oslaman.bestam.network.model

import com.squareup.moshi.Json

data class Rates(
    @Json(name = "AUD")
    val aUD: Double, // 1.5605
    @Json(name = "BGN")
    val bGN: Double, // 1.9558
    @Json(name = "BRL")
    val bRL: Double, // 6.6644
    @Json(name = "CAD")
    val cAD: Double, // 1.5331
    @Json(name = "CHF")
    val cHF: Double, // 1.0986
    @Json(name = "CNY")
    val cNY: Double, // 7.8385
    @Json(name = "CZK")
    val cZK: Double, // 26.195
    @Json(name = "DKK")
    val dKK: Double, // 7.4361
    @Json(name = "EUR")
    val eUR: Double,
    @Json(name = "GBP")
    val gBP: Double, // 0.87053
    @Json(name = "HKD")
    val hKD: Double, // 9.401
    @Json(name = "HRK")
    val hRK: Double, // 7.583
    @Json(name = "HUF")
    val hUF: Double, // 361.43
    @Json(name = "IDR")
    val iDR: Double, // 17353.51
    @Json(name = "ILS")
    val iLS: Double, // 4.0072
    @Json(name = "INR")
    val iNR: Double, // 89.5766
    @Json(name = "ISK")
    val iSK: Double, // 152.9
    @Json(name = "JPY")
    val jPY: Double, // 128.83
    @Json(name = "KRW")
    val kRW: Double, // 1367.1
    @Json(name = "MXN")
    val mXN: Double, // 25.2879
    @Json(name = "MYR")
    val mYR: Double, // 4.9096
    @Json(name = "NOK")
    val nOK: Double, // 10.4012
    @Json(name = "NZD")
    val nZD: Double, // 1.6622
    @Json(name = "PHP")
    val pHP: Double, // 59.09
    @Json(name = "PLN")
    val pLN: Double, // 4.5186
    @Json(name = "RON")
    val rON: Double, // 4.875
    @Json(name = "RUB")
    val rUB: Double, // 90.6697
    @Json(name = "SEK")
    val sEK: Double, // 10.1388
    @Json(name = "SGD")
    val sGD: Double, // 1.6106
    @Json(name = "THB")
    val tHB: Double, // 36.799
    @Json(name = "TRY")
    val tRY: Double, // 9.0168
    @Json(name = "USD")
    val uSD: Double, // 1.2121
    @Json(name = "ZAR")
    val zAR: Double // 18.1025
)