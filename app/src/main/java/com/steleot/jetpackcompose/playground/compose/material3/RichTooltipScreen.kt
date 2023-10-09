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
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "material3/RichTooltipScreen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RichTooltipScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.RichTooltip,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val tooltipState = rememberTooltipState(isPersistent = true)
            val scope = rememberCoroutineScope()
            TooltipBox(
                positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                tooltip = {
                    RichTooltip(
                        title = { Text(stringResource(id = R.string.app_name))},
                        action = {
                            TextButton(
                                onClick = {
                                    scope.launch {
                                        tooltipState.dismiss()
                                    }
                                }
                            ) { Text(stringResource(id = R.string.ok)) }
                        }
                    ) { Text(stringResource(id = R.string.android)) }
                },
                state = tooltipState
            ) {
                IconButton(
                    onClick = { /* Icon button's click event */ },
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