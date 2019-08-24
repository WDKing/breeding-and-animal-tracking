package com.mythcreatures.breedingtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class StartActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // TODO Analytics for Testing Purposes, Removed when not needed
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "001")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "App Open - Testing")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle)
    }
}
