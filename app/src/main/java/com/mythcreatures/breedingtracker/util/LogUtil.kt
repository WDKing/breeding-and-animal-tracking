package com.mythcreatures.breedingtracker.util

import android.util.Log
import com.mythcreatures.breedingtracker.BuildConfig

class LogUtil {

    companion object {

        fun d(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }
    }
}