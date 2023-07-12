package com.oslaman.adhan.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oslaman.adhan.domain.Location

@Entity
data class LocationsEntity constructor(
    @PrimaryKey
    val city: String,
    val latitude: Double,
    val longitude: Double,
)

fun List<LocationsEntity>.asDomainModel(): List<Location> {
    return map {
        Location(
            city = it.city,
            latitude = it.latitude,
            longitude = it.longitude
        )
    }
}