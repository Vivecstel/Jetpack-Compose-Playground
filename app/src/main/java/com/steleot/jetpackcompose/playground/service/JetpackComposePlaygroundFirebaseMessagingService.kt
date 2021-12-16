package com.steleot.jetpackcompose.playground.service

import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import timber.log.Timber
import kotlin.math.pow

class JetpackComposePlaygroundFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Timber.d("Message received with data: ${message.data}")

        val model = NotificationModel(
            message.data[NotificationId]?.toIntOrNull() ?: -1,
            message.data[Priority]?.toIntOrNull() ?: NotificationCompat.PRIORITY_DEFAULT,
            message.data[ContentTitle].orEmpty(),
            message.data[ContentText].orEmpty(),
            NotificationType.valueOfSafe(message.data[Type]),
            message.data[VersionName],
            message.data[DeepLink],
        )

        if (model.hasMissingData || model.isDataNotValid) return

        val builder = NotificationCompat.Builder(this, model.channelId)
            .setSmallIcon(R.drawable.ic_notification) // todo stelios
            .setContentTitle(model.title)
            .setContentText(model.text)
            .setPriority(model.priority)
            .setContentIntent(createPendingIntent(model))

        with(NotificationManagerCompat.from(this)) {
            createChannel(model)
            notify(model.notificationId, builder.build())
        }
    }

    private fun createPendingIntent(
        model: NotificationModel,
    ): PendingIntent? {
        val intent = when (model.type) {
            NotificationType.NEW_VERSION -> Intent(
                Intent.ACTION_VIEW,
                "market://details?id=${BuildConfig.APPLICATION_ID}".toUri()
            )
            NotificationType.DEEP_LINK -> {
                val route =
                    if (model.deepLink.isNullOrEmpty()) MainNavRoutes.Main else model.deepLink
                Intent(
                    Intent.ACTION_VIEW,
                    "${BuildConfig.DEEP_LINK_URI}/$route".toUri(),
                    this,
                    MainActivity::class.java
                )
            }
        }
        Timber.d("Deep link uri: ${intent.data}")
        return PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    private fun NotificationManagerCompat.createChannel(
        model: NotificationModel,
    ) {
        val (name, description) = when (model.type) {
            NotificationType.NEW_VERSION -> getString(R.string.new_version) to getString(R.string.new_version_description)
            else -> getString(R.string.showcase) to getString(R.string.showcase_description)
        }
        val builder = NotificationChannelCompat.Builder(
            model.channelId,
            model.priority + 3
        )
            .setName(name)
            .setDescription(description)
        createNotificationChannel(builder.build())
    }

    override fun onNewToken(token: String) {
        Timber.d("New token retrieved: $token")
    }

    @Suppress("SameParameterValue")
    private class NotificationModel(
        val notificationId: Int,
        val priority: Int,
        val title: String,
        val text: String,
        val type: NotificationType,
        val versionName: String?,
        val deepLink: String?,
    ) {
        val channelId
            get() = when (type) {
                NotificationType.NEW_VERSION -> NewVersionId
                else -> ShowcaseId
            }

        val hasMissingData: Boolean
            get() {
                return notificationId == -1 || title.isEmpty() || text.isEmpty()
            }

        val isDataNotValid: Boolean
            get() {
                return type == NotificationType.NEW_VERSION && (versionName.isNullOrEmpty() || compareVersionNames(
                    BuildConfig.VERSION_NAME,
                    versionName
                ))
            }

        private fun compareVersionNames(
            currentVersionName: String,
            modelVersionName: String,
        ): Boolean = currentVersionName.toComparableInt() >= modelVersionName.toComparableInt()

        private fun String.toComparableInt(): Double = this.split(".")
            .reversed()
            .mapIndexed { index, num ->
                num.toInt() * (10.0.pow(index * 2))
            }.sum()
    }

    private enum class NotificationType {
        NEW_VERSION, DEEP_LINK;

        companion object {
            fun valueOfSafe(name: String?): NotificationType =
                values().find { it.name == name } ?: DEEP_LINK
        }
    }

    private companion object {
        // keys
        const val NotificationId = "notification_id"
        const val Priority = "priority"
        const val ContentTitle = "content_title"
        const val ContentText = "content_text"
        const val Type = "type"
        const val VersionName = "version_name"
        const val DeepLink = "deep_link"

        // channel ids
        const val NewVersionId = "new_version"
        const val ShowcaseId = "showcase"
    }
}