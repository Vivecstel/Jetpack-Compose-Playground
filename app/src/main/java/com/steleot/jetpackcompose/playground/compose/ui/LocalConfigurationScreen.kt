package com.steleot.jetpackcompose.playground.compose.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/LocalConfigurationScreen.kt"

@Composable
fun LocalConfigurationScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalConfiguration.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalConfigurationExample()
        }
    }
}

@Suppress("DEPRECATION")
@Composable
private fun LocalConfigurationExample() {
    val configuration = LocalConfiguration.current
    Text(text = """
        Local configuration values:
        densityDpi: ${configuration.densityDpi}
        fontScale: ${configuration.fontScale}
        locale: ${configuration.locale}
        orientation: ${when (configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT -> "Portrait"
            else -> "Landscape"
        } }
        etc.
    """.trimIndent())
}
