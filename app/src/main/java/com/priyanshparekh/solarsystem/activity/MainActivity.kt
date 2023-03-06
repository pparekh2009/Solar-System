package com.priyanshparekh.solarsystem.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.priyanshparekh.solarsystem.R
import com.priyanshparekh.solarsystem.adapter.BodyAdapter
import com.priyanshparekh.solarsystem.adapter.PlanetPagerAdapter
import com.priyanshparekh.solarsystem.databinding.ActivityMainBinding
import com.priyanshparekh.solarsystem.interfaces.OnItemClickListener
import com.priyanshparekh.solarsystem.model.Planet
import com.priyanshparekh.solarsystem.ui.RotateUpPageTransformer
import com.priyanshparekh.solarsystem.viewmodel.PlanetsViewModel
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bodyNamesList: List<String>
    private lateinit var bodyIdsList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bodyNamesList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
        bodyIdsList = listOf("mercure", "venus", "terre", "mars", "jupiter", "saturne", "uranus", "neptune", "pluton")
        val bodyImageList = listOf(R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupiter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune, R.drawable.pluto)
        val pagerAdapter = PlanetPagerAdapter(bodyImageList, this)

        binding.planetsPager.adapter = pagerAdapter
        binding.planetsPager.setPageTransformer(RotateUpPageTransformer())
        binding.planetsPager.orientation = ORIENTATION_HORIZONTAL
        binding.planetsPager.registerOnPageChangeCallback(object: OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                if (positionOffset < 0.5f) {
                    binding.tvPlanetName.text = bodyNamesList[position]
                    binding.tvPlanetName.alpha = map(positionOffset, 0f, 0.5f, 1f, 0f).absoluteValue
                } else {
                    binding.tvPlanetName.text = bodyNamesList[position + 1]
                    binding.tvPlanetName.alpha = map(positionOffset, 0.5f, 1f, 0f, 1f).absoluteValue
                }
            }
        })
    }

    fun map(value: Float, oldMin: Float, oldMax: Float, newMin: Float, newMax: Float): Float {
        return ((value - oldMin) / (oldMax - oldMin)) * (newMax - newMin) + newMin
    }

    private fun getResponse() {
        val viewModel = ViewModelProvider(this)[PlanetsViewModel::class.java]

        var planets: Planet
        viewModel.getBodies { planet ->
            planets = planet
            planets.bodies = planets.bodies.filter { it.isPlanet }
            val adapter = BodyAdapter(planets.bodies)
            Log.d("TAG", "getResponse: planets: $planets")
        }
    }

    override fun onItemClicked(position: Int) {
        startActivity(Intent(this@MainActivity, PlanetDetailActivity::class.java).putExtra("planetId", bodyIdsList[position]))
    }
}