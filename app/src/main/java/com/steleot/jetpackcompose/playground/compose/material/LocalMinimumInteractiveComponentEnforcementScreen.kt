package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Surface
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold
import timber.log.Timber

private const val URL = "material3/LocalMinimumInteractiveComponentEnforcement3Screen.kt"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LocalMinimumInteractiveComponentEnforcementScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.LocalMinimumInteractiveComponentEnforcement,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                Text(text = stringResource(id = R.string.no_enforced_minimum))
                Surface(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            Timber.d("Not enforced Surface clicked")
                        },
                    color = MaterialTheme.colors.primary
                ) { }
            }

            Text(text = stringResource(id = R.string.enforced_minimum))
            Surface(
                modifier = Modifier
                    .size(35.dp)
                    .clickable {
                        Timber.d("Enforced Surface clicked")
                    },
                color = MaterialTheme.colors.primary
            ) { }
        }
    }
}