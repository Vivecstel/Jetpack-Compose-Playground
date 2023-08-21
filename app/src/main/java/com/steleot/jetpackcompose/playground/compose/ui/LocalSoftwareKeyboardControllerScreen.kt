package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/LocalSoftwareKeyboardControllerScreen.kt"

@Composable
fun LocalSoftwareKeyboardControllerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalSoftwareKeyboardController,
        link = URL,
    ) {
        LocalSoftwareKeyboardControllerExample(paddingValues = it)
    }
}

@Composable
private fun LocalSoftwareKeyboardControllerExample(paddingValues: PaddingValues) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    val focusRequester = FocusRequester()
    val (text, setText) = remember {
        mutableStateOf(context.getString(R.string.close_keyboard_with_ime))
    }
    Column(Modifier.fillMaxSize().padding(paddingValues = paddingValues).padding(16.dp)) {
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
            Text(context.getString(R.string.show_keyboard))
        }
    }
}