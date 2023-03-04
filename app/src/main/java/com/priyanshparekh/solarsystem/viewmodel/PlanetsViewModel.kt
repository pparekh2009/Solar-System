package com.priyanshparekh.solarsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshparekh.solarsystem.model.Planet
import com.priyanshparekh.solarsystem.repository.PlanetsApi
import com.priyanshparekh.solarsystem.repository.RetrofitHelper
import kotlinx.coroutines.launch

class PlanetsViewModel: ViewModel() {

    private var planetsApi: PlanetsApi = RetrofitHelper.getInstance().create(PlanetsApi::class.java)

    fun getBodies(): Planet {
        var bodies = Planet()
        viewModelScope.launch {
            val result = planetsApi.getPlanets()
            bodies = result.body()!!
        }
        return bodies
    }

}