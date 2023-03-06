package com.priyanshparekh.solarsystem.helper

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup

object HelperResizer {

    private const val scaleWidth = 1080 // scale width of ui
    private const val scaleHeight = 1920 // scale height of ui

    private var height: Int = 0
    private var width: Int = 0

    fun getHeightAndWidth(context: Context) {
        getHeight(context)
        getWidth(context)
    }

    private fun getWidth(context: Context): Int {
        width = context.resources.displayMetrics.widthPixels
        return width
    }

    private fun getHeight(context: Context): Int {
        height = context.resources.displayMetrics.heightPixels
        return height
    }

    fun setHeight(mContext: Context, view: View, v_height: Int) {
        val dm: DisplayMetrics = mContext.resources.displayMetrics
        val height: Int = dm.heightPixels * v_height / scaleHeight
        view.layoutParams.height = height
    }

    fun setWidth(mContext: Context, view: View, v_Width: Int) {
        val dm: DisplayMetrics = mContext.resources.displayMetrics
        val width: Int = dm.widthPixels * v_Width / scaleWidth
        view.layoutParams.width = width
    }

    private fun setHeight(h: Int): Int {
        return (height * h) / 1920
    }

    private fun setWidth(w: Int): Int {
        return (width * w) / 1080
    }

    fun setSize(view: View, width: Int, height: Int) {
        view.layoutParams.height = setHeight(height)
        view.layoutParams.width = setWidth(width)
    }

    fun setHeightByWidth(mContext: Context, view: View, v_height: Int) {
        val dm: DisplayMetrics = mContext.resources.displayMetrics
        val height: Int = dm.widthPixels * v_height / scaleWidth
        view.layoutParams.height = height
    }

    fun setSize(view: View, width: Int, height: Int, sameHeightAndWidth: Boolean) {
        if (sameHeightAndWidth) {
            view.layoutParams.height = setWidth(height)
            view.layoutParams.width = setWidth(width)
        } else {
            view.layoutParams.height = setHeight(height)
            view.layoutParams.width = setHeight(width)
        }

    }

    fun setMargin(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        val marginLayoutParams: ViewGroup.MarginLayoutParams =
            view.layoutParams as ViewGroup.MarginLayoutParams
        marginLayoutParams.setMargins(
            setWidth(left),
            setHeight(top),
            setWidth(right),
            setHeight(bottom)
        )
    }

    fun setPadding(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        view.setPadding(left, top, right, bottom)
    }
}
