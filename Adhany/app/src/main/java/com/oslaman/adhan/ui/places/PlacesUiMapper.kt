package com.oslaman.adhan.ui.places

import com.oslaman.adhan.database.Place
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class PlacesUiMapper @Inject constructor(
    @Named("computation")
    private val computationDispatcher: CoroutineDispatcher
) {
    suspend fun mapToSavedPlacesUi(
        places: List<Place>,
        selectedPlace: Place?,
    ): List<PlaceUi> = mapToPlaceUi(
        places = places,
        selectedPlace = selectedPlace,
        areDeletable = true
    )

    suspend fun mapToSearchResultPlacesUi(
        places: List<Place>
    ): List<PlaceUi> = mapToPlaceUi(
        places = places,
        selectedPlace = null,
        areDeletable = false
    )

    private suspend fun mapToPlaceUi(
        places: List<Place>,
        selectedPlace: Place?,
        areDeletable: Boolean
    ): List<PlaceUi> = withContext(computationDispatcher) {
        places.map {
            PlaceUi(
                name = TextResource.fromString(it.name),
                details = TextResource.fromString(it.details ?: ""),
                isSelected = it == selectedPlace,
                isDeletable = areDeletable && it != selectedPlace
            )
        }
    }

    fun mapToSearchPlacesError(
        error: SearchPlacesResult.Empty,
        query: String
    ): TextResource = when (error) {
        SearchPlacesResult.Empty.Error -> TextResource.fromStringId(R.string.error_search_places)
        SearchPlacesResult.Empty.None -> TextResource.fromStringId(
            id = R.string.no_places_found,
            TextResource.fromString(query)
        )
    }

    fun getProvider(): TextResource = TextResource.fromStringId(
        R.string.template_data_from,
        TextResource.fromStringId(R.string.osm_nominatim_credit)
    )
}