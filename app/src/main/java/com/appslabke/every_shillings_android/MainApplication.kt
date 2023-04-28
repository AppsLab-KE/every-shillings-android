package com.appslabke.every_shillings_android

import android.app.Activity
import android.app.Application
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.GlobalRum
import com.datadog.android.rum.RumMonitor
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy
import com.datadog.android.rum.tracking.ComponentPredicate

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDatadog()
    }

    private fun initializeDatadog() {
        val clientToken = "pube45a16b7e7339bb0a7724da5fbd69407"
        val applicationId = "c45e5a0f-97fa-4d28-8435-44010de6a516"
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

        val credentials = Credentials(clientToken, envName, appVariance, applicationId)
        Datadog.initialize(this, credentials, configuration, TrackingConsent.GRANTED)
        GlobalRum.registerIfAbsent(RumMonitor.Builder().build())
    }
}