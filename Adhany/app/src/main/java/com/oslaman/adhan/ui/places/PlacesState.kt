package com.oslaman.adhan.ui.places

data class PlacesState(
    val isLoading: Boolean = false,
    val empty: TextResource? = null,
    val places: List<PlaceUi> = listOf(),
    val provider: TextResource? = null,
    val placeSelected: Event<Unit>? = null
)

data class PlaceUi(
    val name: TextResource,
    val details: TextResource,
    val isSelected: Boolean,
    val isDeletable: Boolean
)