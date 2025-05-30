package com.payclip.blaze.toolargetool

import android.util.Log
import com.payclip.blaze.commons.analytics.Analytics
import com.payclip.blaze.commons.analytics.AnalyticsProperties
import com.payclip.blaze.commons.analytics.engines.AnalyticsEngine
import com.payclip.blaze.commons.analytics.engines.ErrorContext

/**
 * Interface that allows flexibility in how TooLargeTool's output is logged. The default
 * implementation [LogcatLogger] should be suitable in most cases.
 */
interface Logger {
    fun log(msg: String)
    fun logException(e: Exception)
}

/**
 * The default implementation of [Logger].
 *
 */
class LogcatLogger(
    private val priority: Int = Log.DEBUG,
    private val tag: String = "TooLargeTool"
) : Logger {

    private val analytics: AnalyticsEngine by lazy {
        Analytics.instance()
    }

    override fun log(msg: String) {
        Log.println(priority, tag, msg)
        trackBundle(msg)
    }

    override fun logException(e: Exception) {
        Log.w(tag, e.message, e)
        trackException(e)
    }

    private fun trackBundle(msg: String) {
        val event = SEGMENT_ACTION_BUNDLE
        val params: AnalyticsProperties = hashMapOf(
            SEGMENT_PARAM_MESSAGE to msg
        )

        analytics.trackEvent(
            eventName = event,
            properties = params
        )
    }

    private fun trackException(e: Exception) {
        analytics.trackError(
            error = e,
            errorContext = ErrorContext(tag)
        )
    }

    companion object {
        // Events
        private const val SEGMENT_ACTION_BUNDLE = "TRACK_BUNDLE_DEBUG"

        // Params
        private const val SEGMENT_PARAM_MESSAGE = "tool_message"
    }
}
