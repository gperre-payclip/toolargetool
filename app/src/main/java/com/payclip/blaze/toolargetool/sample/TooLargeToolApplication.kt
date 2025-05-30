package com.payclip.blaze.toolargetool.sample

import android.app.Application
import com.payclip.blaze.commons.analytics.Analytics

import com.payclip.blaze.toolargetool.TooLargeTool

@Suppress("unused")
class TooLargeToolApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TooLargeTool.startLogging(this)
        Analytics.withContext(this).init()
    }
}
