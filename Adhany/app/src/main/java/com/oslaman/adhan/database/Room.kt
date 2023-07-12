package com.oslaman.adhan.database

import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

interface LocationsDao {
    @Query("select * from LocationEntity")
    fun getLocations(): Flow<List<LocationEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocations(users: List<LocationEntity>)

    //@Query("select * from DetailsEntity WHERE user LIKE :user")
    //fun getDetails(user: String): Flow<DetailsEntity?>

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //fun insertDetails(detailsEntity: DetailsEntity)
}

@Database(entities = [LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val locationsDao: LocationsDao
}