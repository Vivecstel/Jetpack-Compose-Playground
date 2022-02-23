package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/LocalAutofillScreen.kt"

@Composable
fun LocalAutofillScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalAutofill,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalAutofillExample()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun LocalAutofillExample() {
    val autofill = LocalAutofill.current
    val (value, setValue) = remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value
    val node = AutofillNode(listOf(AutofillType.EmailAddress)) {
        setValue(it)
    }

    if (isFocused) {
        autofill?.requestAutofillForNode(node)
    } else {
        autofill?.cancelAutofillForNode(node)
    }

    TextField(
        value = value,
        onValueChange = setValue,
        interactionSource = interactionSource
    )
}