package com.steleot.jetpackcompose.playground

import android.app.Application
import android.appwidget.AppWidgetManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.messaging.FirebaseMessaging
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.utils.handleEnableSubscription
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import android.content.Intent

import android.content.ComponentName
import com.steleot.jetpackcompose.playground.appwidget.PlaygroundGlanceAppWidgetReceiver

@HiltAndroidApp
class PlaygroundApplication : Application() {

    private val scope = CoroutineScope(Dispatchers.Main)

    @Inject
    lateinit var inAppReviewHelper: InAppReviewHelper

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var firebaseMessaging: FirebaseMessaging

    @Inject
    lateinit var firebaseCrashlytics: FirebaseCrashlytics

    @Inject
    lateinit var protoManager: ProtoManager

    override fun onCreate() {
        super.onCreate()
        inAppReviewHelper.resetCounter()
        scope.launch {
            protoManager.isAnalyticsEnabled.collect { isEnabled ->
                Timber.d("Analytics collection: $isEnabled")
                firebaseAnalytics.setAnalyticsCollectionEnabled(isEnabled)
            }
        }
        scope.launch {
            protoManager.isMessagingEnabled.collect { isEnabled ->
                Timber.d("Messaging: $isEnabled")
                firebaseMessaging.handleEnableSubscription(isEnabled)
            }
        }
        scope.launch {
            protoManager.isCrashlyticsEnabled.collect { isEnabled ->
                Timber.d("Crashlytics collection: $isEnabled")
                firebaseCrashlytics.setCrashlyticsCollectionEnabled(isEnabled)
            }
        }
    }

    private fun updateWidgets() {
        val intent = Intent(this, PlaygroundGlanceAppWidgetReceiver::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        val ids: IntArray = AppWidgetManager.getInstance(this).getAppWidgetIds(ComponentName(this, PlaygroundGlanceAppWidgetReceiver::class.java))
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
        sendBroadcast(intent)
    }
}