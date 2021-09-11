package com.steleot.jetpackcompose.playground.datastore

import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.DarkThemeMode
import com.steleot.jetpackcompose.playground.theme.ThemeState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Suppress("unused")
class EmptyProtoManager : ProtoManager {

    override val isAnalyticsEnabled: Flow<Boolean> = flowOf(false)

    override val isMessagingEnabled: Flow<Boolean> = flowOf(false)

    override val isCrashlyticsEnabled: Flow<Boolean> = flowOf(false)

    override val reviewTimeStamp: Flow<Long> = flowOf(0)

    override val themeState: Flow<ThemeState> = flowOf(ThemeState())

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

    override suspend fun setDarkThemeMode(darkThemeMode: DarkThemeMode) {
        /* empty implementation */
    }
}