package com.steleot.jetpackcompose.playground.datastore

import android.content.Context
import androidx.datastore.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val FILE_NAME = "SettingsPrefFile"

private val Context.internalDataStore by dataStore(
    fileName = FILE_NAME,
    serializer = SettingsProtoSerializer
)

class ProtoManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    val isAnalyticsEnabled
        get() = context.internalDataStore.data.map { settings ->
            settings.analyticsEnabled
        }

    val isCrashlyticsEnabled
        get() = context.internalDataStore.data.map { settings ->
            settings.crashlyticsEnabled
        }

    val reviewTimeStamp
        get() = context.internalDataStore.data.map { settings ->
            settings.reviewTimeStamp
        }

    suspend fun setIsAnalyticsEnabled(isEnabled: Boolean) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setAnalyticsEnabled(isEnabled)
                .build()
        }
    }

    suspend fun setIsCrashlyticsEnabled(isEnabled: Boolean) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setCrashlyticsEnabled(isEnabled)
                .build()
        }
    }

    suspend fun setReviewTimeStamp(timeStamp: Long) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setReviewTimeStamp(timeStamp)
                .build()
        }
    }
}