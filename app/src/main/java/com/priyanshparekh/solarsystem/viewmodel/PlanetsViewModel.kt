package com.priyanshparekh.solarsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshparekh.solarsystem.model.Body
import com.priyanshparekh.solarsystem.model.Planet
import com.priyanshparekh.solarsystem.repository.PlanetsApi
import com.priyanshparekh.solarsystem.repository.RetrofitHelper
import kotlinx.coroutines.launch

class PlanetsViewModel: ViewModel() {

    private var planetsApi: PlanetsApi = RetrofitHelper.getInstance().create(PlanetsApi::class.java)

    fun getBodies(onResult:(Planet) -> Unit) {
        var bodies = Planet()
        viewModelScope.launch {
            val result = planetsApi.getPlanets()
            bodies = result.body()!!
            onResult(bodies)
        }
    }

    fun getBodyDetails(id: String, onResponse: (body: Body) -> Unit) {
        viewModelScope.launch {
            val body = planetsApi.getBodyDetails(id).body()
            body?.let { onResponse(it) }
        }
    }

}