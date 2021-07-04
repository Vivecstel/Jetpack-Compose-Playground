package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import timber.log.Timber

private const val Url = "runtime/DisposableEffectScreen.kt"

@Composable
fun DisposableEffectScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.DisposableEffect,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val userValue = disposableEffectExample()
            Text("User name is: ${userValue?.name ?: "empty"}")
        }
    }
}

@Composable
private fun disposableEffectExample(
    userId: Int = 0
): User? {
    val user = remember(userId) { mutableStateOf<User?>(null) }
    DisposableEffect(userId) {
        val subscription = UserAPI.subscribeToUser(userId) {
            user.value = it
        }
        onDispose {
            subscription.unsubscribe()
        }
    }
    return user.value
}

private class Subscription {
    fun unsubscribe() {
        Timber.d("unsubscribe successful")
    }
}

private object UserAPI {
    fun subscribeToUser(
        userId:
        Int, user: (User) -> Unit
    ): Subscription {
        user(User(userId, "Jetpack Compose Playground"))
        return Subscription()
    }
}
