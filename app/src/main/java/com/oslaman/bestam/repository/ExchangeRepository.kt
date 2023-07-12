package com.oslaman.bestam.repository


import com.oslaman.bestam.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ExchangeRepository @Inject constructor(remoteDataSource: RemoteDataSource) {
    val remote = remoteDataSource
}