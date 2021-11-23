package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import jp.wasabeef.gap.Gap

private const val Url = "externallibraries/GapScreen.kt"

@Composable
fun GapScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Gap,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GapExample()
        }
    }
}

@Composable
private fun GapExample() {
    Column {
        Text(text = stringResource(id = R.string.hello))
        Gap(20.dp)
        Text(text = stringResource(id = R.string.app_name))
    }

    Row {
        Text(text = stringResource(id = R.string.hello))
        Gap(20.dp)
        Text(text = stringResource(id = R.string.app_name))
    }
}