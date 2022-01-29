package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import timber.log.Timber

private const val Url = "material3/LocalMinimumTouchTargetEnforcementScreen.kt"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LocalMinimumTouchTargetEnforcementScreen() {
    DefaultScaffold3(
        title = Material3NavRoutes.LocalMinimumTouchTargetEnforcement,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Text(text = stringResource(id = R.string.no_enforced_minimum))
                Surface(
                    onClick = {
                        Timber.d("Not enforced Surface clicked")
                    },
                    modifier = Modifier
                        .size(35.dp),
                    color = MaterialTheme.colorScheme.primary
                ) { }
            }

            Text(text = stringResource(id = R.string.enforced_minimum))
            Surface(
                onClick = {
                    Timber.d("Enforced Surface clicked")
                },
                modifier = Modifier
                    .size(35.dp),
                color = MaterialTheme.colorScheme.primary
            ) { }
        }
    }
}