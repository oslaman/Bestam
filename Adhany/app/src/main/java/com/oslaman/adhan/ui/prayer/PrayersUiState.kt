package com.oslaman.adhan.ui.prayer

import com.oslaman.adhan.domain.Prayer

data class PrayersUiState (
    val list: List<Prayer> = listOf(),
    val city: String = "",
    val coordinates: Coordinates = Coordinates()
)

data class Coordinates(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)