package com.steleot.jetpackcompose.playground.api.serializers

import android.annotation.SuppressLint
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateSerializer : KSerializer<Date> {

    @SuppressLint("ConstantLocale")
    private val df: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateSerializer", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Date {
        return df.parse(decoder.decodeString()) as Date
    }

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(df.format(value))
    }
}