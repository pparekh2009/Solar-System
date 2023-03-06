package com.priyanshparekh.solarsystem.repository

import com.priyanshparekh.solarsystem.model.Body
import com.priyanshparekh.solarsystem.model.Planet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlanetsApi {
    @GET("bodies/")
    suspend fun getPlanets(): Response<Planet>

    @GET("bodies/{id}")
    suspend fun getBodyDetails(@Path(value = "id") id: String): Response<Body>
}