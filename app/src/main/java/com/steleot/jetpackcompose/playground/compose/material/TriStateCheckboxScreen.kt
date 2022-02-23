package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/TriStateCheckboxScreen.kt"

@Composable
fun TriStateCheckboxScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.TriStateCheckbox,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val (state, onStateChange) = remember { mutableStateOf(true) }
            val (state2, onStateChange2) = remember { mutableStateOf(true) }
            val parentState = remember(state, state2) {
                if (state && state2) ToggleableState.On
                else if (!state && !state2) ToggleableState.Off
                else ToggleableState.Indeterminate
            }
            val onParentClick = {
                val s = parentState != ToggleableState.On
                onStateChange(s)
                onStateChange2(s)
            }

            TriStateCheckbox(
                state = parentState,
                onClick = onParentClick,
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.primary
                )
            )
            Column(Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                Checkbox(state, onStateChange)
                Checkbox(state2, onStateChange2)
            }
        }
    }
}