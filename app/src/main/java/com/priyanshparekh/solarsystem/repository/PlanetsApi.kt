package com.priyanshparekh.solarsystem.repository

import com.priyanshparekh.solarsystem.model.Planet
import retrofit2.Response
import retrofit2.http.GET

interface PlanetsApi {
    @GET("bodies/")
    suspend fun getPlanets(): Response<Planet>
}