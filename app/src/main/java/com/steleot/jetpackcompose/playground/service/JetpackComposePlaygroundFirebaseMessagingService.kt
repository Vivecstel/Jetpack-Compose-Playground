package com.steleot.jetpackcompose.playground.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class JetpackComposePlaygroundFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Timber.d("Message received with data: ${message.data}")
    }

    override fun onNewToken(token: String) {
        Timber.d("New token retrieved: $token")
    }
}