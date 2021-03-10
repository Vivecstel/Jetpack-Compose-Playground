package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
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
import java.util.*

@Composable
fun SoftwareKeyboardControllerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.SoftwareKeyboardController.capitalize(Locale.getDefault())
    ) {
        SoftwareKeyboardControllerExample()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SoftwareKeyboardControllerExample() {
    val keyboardController = LocalSoftwareKeyboardController.current

    val focusRequester = FocusRequester()
    val (text, setText) = remember {
        mutableStateOf("Close keyboard on done ime action (blue ✔️)")
    }
    Column(Modifier.padding(16.dp)) {
        BasicTextField(
            text,
            setText,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hideSoftwareKeyboard() }
            ),
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                focusRequester.requestFocus()
                keyboardController?.showSoftwareKeyboard()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show software keyboard.")
        }
    }
}