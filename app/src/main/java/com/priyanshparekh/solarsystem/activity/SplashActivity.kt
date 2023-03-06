package com.priyanshparekh.solarsystem.activity

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import androidx.appcompat.app.AppCompatActivity
import com.priyanshparekh.solarsystem.R
import com.priyanshparekh.solarsystem.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chars = "Solar\nSystem"
        val spannableString = SpannableString(chars)
        spannableString.setSpan(AbsoluteSizeSpan(150), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableString.setSpan(AbsoluteSizeSpan(100), 6, chars.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        binding.tvSplash.text = spannableString

        binding.tvSplash.animate()
            .translationX(-100f)
            .scaleXBy(65f)
            .scaleYBy(65f)
            .setStartDelay(1000)
            .setInterpolator(AccelerateInterpolator())
            .duration = 2000

        val path = "android.resource://$packageName/${R.raw.splashvideo}"

        binding.vvSplashVideo.setVideoURI(Uri.parse(path))
        binding.vvSplashVideo.setOnCompletionListener { binding.vvSplashVideo.start() };
        Handler().postDelayed({
            binding.vvSplashVideo.start()
            binding.vvSplashVideo
            binding.vvSplashVideo.visibility = View.VISIBLE
            binding.vvSplashVideo.animate().scaleX(1.5f).scaleY(1.5f).duration = 2000
        }, 3000)
    }

    override fun onResume() {
        super.onResume()

        runnable = Runnable {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }

        handler = Handler()
        handler.postDelayed(runnable, 5000)
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }
}