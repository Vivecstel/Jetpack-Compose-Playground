package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/LocalSoftwareKeyboardControllerScreen.kt"

@Composable
fun LocalSoftwareKeyboardControllerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalSoftwareKeyboardController.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        LocalSoftwareKeyboardControllerExample()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun LocalSoftwareKeyboardControllerExample() {
    val keyboardController = LocalSoftwareKeyboardController.current

    val focusRequester = FocusRequester()
    val (text, setText) = remember {
        mutableStateOf("Close keyboard on done ime action (blue ✔️)")
    }
    Column(Modifier.padding(16.dp)) {
        TextField(
            text,
            setText,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                focusRequester.requestFocus()
                keyboardController?.show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show software keyboard.")
        }
    }
}