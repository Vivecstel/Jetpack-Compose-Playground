package com.steleot.jetpackcompose.playground.datastore

import com.steleot.jetpackcompose.playground.theme.ColorPalette
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Suppress("unused")
class EmptyProtoManager : ProtoManager {

    override val isAnalyticsEnabled: Flow<Boolean> = flowOf(false)

    override val isMessagingEnabled: Flow<Boolean> = flowOf(false)

    override val isCrashlyticsEnabled: Flow<Boolean> = flowOf(false)

    override val reviewTimeStamp: Flow<Long> = flowOf(0)

    override val colorPalette: Flow<ColorPalette> = flowOf(ColorPalette.DEEP_PURPLE)

    override suspend fun setIsAnalyticsEnabled(isEnabled: Boolean) {
        /* empty implementation */
    }

    override suspend fun setIsMessagingEnabled(isEnabled: Boolean) {
        /* empty implementation */
    }

    override suspend fun setIsCrashlyticsEnabled(isEnabled: Boolean) {
        /* empty implementation */
    }

    override suspend fun setReviewTimeStamp(timeStamp: Long) {
        /* empty implementation */
    }

    override suspend fun setColorPalette(colorPalette: ColorPalette) {
        /* empty implementation */
    }
}