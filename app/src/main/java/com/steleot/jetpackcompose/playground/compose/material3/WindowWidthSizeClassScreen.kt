package com.steleot.jetpackcompose.playground.compose.material3

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.resources.R

private const val URL = "material3/WindowWidthSizeClassScreen.kt"

@Composable
fun WindowWidthSizeClassScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.WindowWidthSizeClass,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WindowWidthSizeClassExample()
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
private fun WindowWidthSizeClassExample() {
    val context = LocalContext.current
    val message = context.findActivity()?.let {
        val windowSizeClass = calculateWindowSizeClass(activity = it)
        """
            widthSizeClass: ${windowSizeClass.widthSizeClass}
            heightSizeClass: ${windowSizeClass.heightSizeClass}
        """.trimIndent()
    } ?: context.getString(R.string.failed_to_retrive_window_size_class)

    Text(text = message)
}

private fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}