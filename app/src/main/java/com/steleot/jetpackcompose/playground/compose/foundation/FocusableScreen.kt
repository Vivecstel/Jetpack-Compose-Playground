package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/FocusableScreen.kt"

@Composable
fun FocusableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Focusable,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FocusableExample()
        }
    }
}

@Composable
private fun FocusableExample() {
    val focusRequester = FocusRequester()
    val interactionSource = remember { MutableInteractionSource() }

    val isFocused = interactionSource.collectIsFocusedAsState().value
    val text = if (isFocused) {
        "Focused! tap anywhere to free the focus"
    } else {
        "Bring focus to me by tapping the button below!"
    }
    Column {
        Text(
            text = text,
            modifier = Modifier
                .focusRequester(focusRequester)
                .focusable(interactionSource = interactionSource)
        )
        Button(onClick = { focusRequester.requestFocus() }) {
            Text("Bring focus to the text above")
        }
    }
}