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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/LocalConfigurationScreen.kt"

@Composable
fun LocalConfigurationScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalConfiguration,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
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
    Text(
        text = stringResource(
            id = R.string.local_configuration_value,
            configuration.densityDpi,
            configuration.fontScale,
            configuration.locale,
            stringResource(
                id = if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                    R.string.portrait else R.string.landscape
            )
        )
    )
}
