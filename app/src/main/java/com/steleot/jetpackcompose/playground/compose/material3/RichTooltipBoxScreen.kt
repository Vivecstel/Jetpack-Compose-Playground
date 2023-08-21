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
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberRichTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "material3/RichTooltipBoxScreen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RichTooltipBoxScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.RichTooltipBox,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val tooltipState = rememberRichTooltipState(isPersistent = true)
            val scope = rememberCoroutineScope()
            RichTooltipBox(
                title = { Text(stringResource(id = R.string.app_name)) },
                action = {
                    TextButton(
                        onClick = { scope.launch { tooltipState.dismiss() } }
                    ) { Text(stringResource(id = R.string.ok)) }
                },
                text = { Text(stringResource(id = R.string.android)) },
                tooltipState = tooltipState,
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