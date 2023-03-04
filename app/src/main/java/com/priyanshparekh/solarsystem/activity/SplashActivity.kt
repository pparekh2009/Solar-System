package com.priyanshparekh.solarsystem.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.priyanshparekh.solarsystem.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        runnable = Runnable {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }

        handler = Handler()
        handler.postDelayed(runnable, 3000)
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }
}