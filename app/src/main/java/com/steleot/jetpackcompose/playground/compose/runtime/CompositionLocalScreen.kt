package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import timber.log.Timber

private const val Url = "runtime/CompositionLocalScreen.kt"

@Composable
fun CompositionLocalScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.CompositionLocal,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider(ActiveUser provides User()) {
                CurrentUserSuccess()
            }
            CurrentUserFailure()
        }
    }
}

@Composable
private fun CurrentUserSuccess() {
    val user = ActiveUser.current
    Text(text = "Active user name is : ${user.name}")
}

@Composable
private fun CurrentUserFailure() {
    val user = ActiveUser.current
    Text(text = "Active user name is : ${user.name}")
}

@Suppress("CompositionLocalNaming")
private val ActiveUser = compositionLocalOf {
    Timber.e("No active user found. Better to throw an exception here instead of timber.")
    User(name = "Default User")
}

internal class User(
    val id: Int = 0,
    val name: String = "Jetpack compose",
)