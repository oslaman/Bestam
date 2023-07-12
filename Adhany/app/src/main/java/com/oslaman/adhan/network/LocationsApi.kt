package com.oslaman.adhan.network

import retrofit2.http.GET

interface LocationsApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUsers(): List<UserApiModel>
}