package com.steleot.jetpackcompose.playground.datastore

import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.DarkThemeMode
import timber.log.Timber
import java.io.InputStream
import java.io.OutputStream

object SettingsProtoSerializer : Serializer<SettingsProto> {

    override val defaultValue: SettingsProto
        get() = SettingsProto.getDefaultInstance()
            .toBuilder()
            .setAnalyticsEnabled(!BuildConfig.DEBUG)
            .setCrashlyticsEnabled(!BuildConfig.DEBUG)
            .setMessagingEnabled(true)
            .setColorPalette(ColorPalette.DEEP_PURPLE.name)
            .setDarkMode(DarkThemeMode.SYSTEM.name)
            .build()

    override suspend fun readFrom(input: InputStream): SettingsProto {
        return try {
            SettingsProto.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            Timber.e(e)
            defaultValue
        }
    }

    override suspend fun writeTo(t: SettingsProto, output: OutputStream) {
        t.writeTo(output)
    }
}
