package com.oslaman.adhan.repository

import com.oslaman.adhan.database.AppDatabase
import com.oslaman.adhan.database.asDomainModel
import com.oslaman.adhan.domain.Location
import com.oslaman.adhan.network.LocationsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

/*
class LocationsRepository @Inject constructor(
    private val locationsApi: LocationsApi,
    private val appDatabase: AppDatabase
) {
    val locations: Flow<List<Location>?> =
        appDatabase.locationsDao.getLocations().map { it?.asDomainModel }

    suspend fun refreshLocations() {
        try {
            val locations = locationsApi.getLocations()
            appDatabase.locationsDao.insertLocations(locations.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}*/
