package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.resources.R

private const val URL = "material3/PlainTooltipBoxScreen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlainTooltipBoxScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.PlainTooltipBox,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlainTooltipBox(
                tooltip = { Text(stringResource(id = R.string.app_name)) }
            ) {
                IconButton(
                    onClick = { /* Icon button's click event */ },
                    modifier = Modifier.tooltipTrigger()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Android,
                        contentDescription = stringResource(id = R.string.android),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}