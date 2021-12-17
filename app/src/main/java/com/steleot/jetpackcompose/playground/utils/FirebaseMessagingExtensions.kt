package com.steleot.jetpackcompose.playground.utils

import com.google.firebase.messaging.FirebaseMessaging

fun FirebaseMessaging.handleEnableSubscription(
    isEnabled: Boolean
) {
    if (isEnabled) {
        this.subscribeToTopic("all")
    } else {
        this.unsubscribeFromTopic("all")
    }
}