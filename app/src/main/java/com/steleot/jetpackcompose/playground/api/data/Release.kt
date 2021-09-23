package com.steleot.jetpackcompose.playground.api.data

import com.steleot.jetpackcompose.playground.api.serializers.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Release(
    @SerialName("id") val id: Int,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("tag_name") val tagName: String,
    @SerialName("name") val name: String,
    @SerialName("body") val body: String,
    @SerialName("created_at") @Serializable(with = DateSerializer::class) val createdAt: Date?,
    /* ignore rest attributes */
)