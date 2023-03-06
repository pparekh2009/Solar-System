package com.priyanshparekh.solarsystem.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.priyanshparekh.solarsystem.databinding.ActivityPlanetDetailBinding
import com.priyanshparekh.solarsystem.viewmodel.PlanetsViewModel

class PlanetDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String? = intent.extras?.getString("planetId")
        Log.d("TAG", "onCreate: id: $id")

        val viewModel: PlanetsViewModel = ViewModelProvider(this)[PlanetsViewModel::class.java]
        viewModel.getBodyDetails(id!!) {
            Log.d("TAG", "onCreate: body: $it")
        }
    }
}