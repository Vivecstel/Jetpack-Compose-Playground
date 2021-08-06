package com.steleot.jetpackcompose.playground.helpers

import android.app.Activity

class EmptyInAppReviewHelper : InAppReviewHelper {

    override suspend fun requestReview(activity: Activity) {

    }

    override fun resetCounter() {

    }
}