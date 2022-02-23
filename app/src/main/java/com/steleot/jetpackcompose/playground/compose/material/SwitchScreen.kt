package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/SwitchScreen.kt"

@Composable
fun SwitchScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Switch,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSwitch()
            DisabledSwitch()
            CheckedThumbColorSwitch()
            CheckedTrackColorSwitch()
            CheckedTrackAlphaSwitch()
            UncheckedThumbColorSwitch()
            UncheckedTrackColorSwitch()
            UncheckedTrackAlphaSwitch()
            DisabledCheckedThumbColorSwitch()
            DisabledCheckedTrackColorSwitch()
            DisabledUncheckedThumbColorSwitch()
            DisabledUncheckedTrackColorSwitch()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultSwitch() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledSwitch() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        enabled = false
    )
}

@Preview(showBackground = true)
@Composable
private fun CheckedThumbColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedThumbColor = Color.Red
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CheckedTrackColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedTrackColor = Color.Red
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CheckedTrackAlphaSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedTrackColor = Color.Red,
            checkedTrackAlpha = 0.1f
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun UncheckedThumbColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedThumbColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun UncheckedTrackColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedTrackColor = Color.LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun UncheckedTrackAlphaSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedTrackColor = Color.LightGray,
            uncheckedTrackAlpha = 0.1f
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledCheckedThumbColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledCheckedThumbColor = Color.Green
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledCheckedTrackColorSwitch() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledCheckedTrackColor = Color.DarkGray
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledUncheckedThumbColorSwitch() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledUncheckedThumbColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledUncheckedTrackColorSwitch() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledUncheckedTrackColor = Color.LightGray
        )
    )
}