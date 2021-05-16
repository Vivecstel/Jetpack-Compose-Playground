package com.steleot.jetpackcompose.playground.helpers

import com.google.android.play.core.tasks.Task
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun <T> Task<T>.await(): T {
    if (isComplete) {
        val e = exception
        return if (e == null) {
            result
        } else {
            Timber.e(e)
            throw e
        }
    }

    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            val e = exception
            if (e == null) {
                cont.resume(result) {
                    cont.cancel()
                }
            } else {
                Timber.e(e)
                cont.resumeWithException(e)
            }
        }
    }
}