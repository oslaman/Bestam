package com.oslaman.adhan.network.model

import com.oslaman.adhan.database.LocationsEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class LocationsApiModel (
    @Json(name = "results")
    val results: List<Location> = emptyList(),
    @Json(name = "generationtime_ms")
    val generationtimeMS: Double
)

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "latitude")
    val latitude: Double? = null,
    @Json(name = "longitude")
    val longitude: Double? = null,
    @Json(name = "elevation")
    val elevation: Double? = null,
    @Json(name = "feature_code")
    val featureCode: String? = null,
    @Json(name = "country_code")
    val countryCode: String? = null,
    @Json(name = "admin1_id")
    val admin1ID: Long? = null,
    @Json(name = "admin2_id")
    val admin2ID: Long? = null,
    @Json(name = "admin3_id")
    val admin3ID: Long? = null,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "population")
    val population: Long? = null,
    @Json(name = "country_id")
    val countryID: Long? = null,
    @Json(name = "country_")
    val country: String? = null,
    @Json(name = "admin1")
    val admin1: String? = null,
    @Json(name = "admin2")
    val admin2: String? = null,
    @Json(name = "admin3")
    val admin3: String? = null
)

fun LocationsApiModel.asDatabaseModel(): LocationsEntity {
    return LocationsEntity(
        city = results[0].name,
        avatar = avatarUrl,
        name = name ?: "",
        userSince = createdAt ?: "",
        location = location ?: ""
    )

}
