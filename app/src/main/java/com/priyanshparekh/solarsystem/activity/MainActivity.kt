package com.priyanshparekh.solarsystem.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.priyanshparekh.solarsystem.databinding.ActivityMainBinding
import com.priyanshparekh.solarsystem.viewmodel.PlanetsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetBodies.setOnClickListener { getResponse() }
    }

    private fun getResponse() {
        val viewModel = ViewModelProvider(this)[PlanetsViewModel::class.java]

        val planets = viewModel.getBodies().bodies

        Log.d("TAG", "getResponse: planets: $planets")
    }
}