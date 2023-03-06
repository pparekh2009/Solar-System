package com.priyanshparekh.solarsystem.ui

import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class RotateUpPageTransformer: ViewPager2.PageTransformer {

    private val ROTATION = -15f

    override fun transformPage(page: View, pos: Float ) {
        val width: Float = page.width.toFloat()
        val height: Float = page.height.toFloat()
        val rotation: Float = ROTATION * pos * -1.25f;

        page.pivotX = width * 0.5f
        page.pivotY = height
        page.rotation = rotation

    }

}