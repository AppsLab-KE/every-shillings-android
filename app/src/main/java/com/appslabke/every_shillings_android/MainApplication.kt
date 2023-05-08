package com.appslabke.every_shillings_android

import android.app.Activity
import android.app.Application
import com.appslabke.every_shillings_android.Constants.APP_ID
import com.appslabke.every_shillings_android.Constants.CLIENT_TOKEN
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.GlobalRum
import com.datadog.android.rum.RumMonitor
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy
import com.datadog.android.rum.tracking.ComponentPredicate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDatadog()
    }

    private fun initializeDatadog() {
        val envName = BuildConfig.BUILD_TYPE
        val appVariance = ""

        val configuration = Configuration.Builder(
            tracesEnabled = true,
            rumEnabled = true,
            logsEnabled = true,
            crashReportsEnabled = true
        )
            .trackInteractions()
            .trackLongTasks(250L)
            .useViewTrackingStrategy(
                ActivityViewTrackingStrategy(
                    trackExtras = true,
                    componentPredicate = object : ComponentPredicate<Activity> {
                        override fun accept(component: Activity): Boolean {
                            return component !is MainActivity
                        }

                        override fun getViewName(component: Activity): String? {
                            return null
                        }

                    }
                )
            )
            .useSite(DatadogSite.US5)
            .build()

        val credentials = Credentials(CLIENT_TOKEN, envName, appVariance, APP_ID)
        Datadog.initialize(this, credentials, configuration, TrackingConsent.GRANTED)
        GlobalRum.registerIfAbsent(RumMonitor.Builder().build())
    }
}