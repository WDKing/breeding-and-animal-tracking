package com.mythcreatures.breedingtracker.base

import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityCompat
import com.mythcreatures.breedingtracker.util.LogUtil

interface BasePresenter {

    fun startActivity(context: Context, classToStart: Class<*>) {
        LogUtil.d("BasePresenter-startActivity","Class to start: ${classToStart.toString()}")
        val intent = Intent(context, classToStart)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        ActivityCompat.startActivity(context, intent, null)
    }

}
