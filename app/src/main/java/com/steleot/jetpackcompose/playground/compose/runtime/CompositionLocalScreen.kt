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
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
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
                CurrentUser()
            }
            CurrentUser()
        }
    }
}

@Composable
private fun CurrentUser() {
    val user = ActiveUser.current
    Text(text = stringResource(id = R.string.user_name, user.name))
}

@Suppress("CompositionLocalNaming")
private val ActiveUser = compositionLocalOf {
    Timber.e("No active user found. Better to throw an exception here instead of timber.")
    User(name = "John Doe")
}

internal class User(
    val id: Int = 0,
    val name: String = "Jetpack Compose Playground",
)