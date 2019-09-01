package com.mythcreatures.breedingtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;

class StartActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // TODO Analytics & Performance for Testing Purposes, Removed when not needed
        val myTrace = FirebasePerformance.getInstance().newTrace("test_trace")
        myTrace.start()

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "001")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "App Open - Testing")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle)

        myTrace.stop()
        // TODO End of Testing
    }
}
