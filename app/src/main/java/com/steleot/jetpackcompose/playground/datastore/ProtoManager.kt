package com.steleot.jetpackcompose.playground.datastore

import android.content.Context
import androidx.datastore.dataStore
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

private const val FILE_NAME = "SettingsPrefFile"

private val Context.internalDataStore by dataStore(
    fileName = FILE_NAME,
    serializer = SettingsProtoSerializer
)

interface ProtoManager {

    val isAnalyticsEnabled: Flow<Boolean>
    val isCrashlyticsEnabled: Flow<Boolean>
    val reviewTimeStamp: Flow<Long>
    val colorPalette: Flow<ColorPalette>
    suspend fun setIsAnalyticsEnabled(isEnabled: Boolean)
    suspend fun setIsCrashlyticsEnabled(isEnabled: Boolean)
    suspend fun setReviewTimeStamp(timeStamp: Long)
    suspend fun setColorPalette(colorPalette: ColorPalette)
}

class ProtoManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ProtoManager {

    override val isAnalyticsEnabled
        get() = context.internalDataStore.data.map { settings ->
            settings.analyticsEnabled
        }

    override val isCrashlyticsEnabled
        get() = context.internalDataStore.data.map { settings ->
            settings.crashlyticsEnabled
        }

    override val reviewTimeStamp
        get() = context.internalDataStore.data.map { settings ->
            settings.reviewTimeStamp
        }

    override val colorPalette: Flow<ColorPalette>
        get() = context.internalDataStore.data.map { settings ->
            try {
                ColorPalette.valueOf(settings.colorPalette)
            } catch (e: Exception) {
                Timber.e(e)
                ColorPalette.DEEP_PURPLE
            }
        }

    override suspend fun setIsAnalyticsEnabled(isEnabled: Boolean) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setAnalyticsEnabled(isEnabled)
                .build()
        }
    }

    override suspend fun setIsCrashlyticsEnabled(isEnabled: Boolean) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setCrashlyticsEnabled(isEnabled)
                .build()
        }
    }

    override suspend fun setReviewTimeStamp(timeStamp: Long) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setReviewTimeStamp(timeStamp)
                .build()
        }
    }

    override suspend fun setColorPalette(colorPalette: ColorPalette) {
        context.internalDataStore.updateData { settings ->
            settings.toBuilder()
                .setColorPalette(colorPalette.name)
                .build()
        }
    }
}