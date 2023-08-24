package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/FocusableScreen.kt"

@Composable
fun FocusableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Focusable,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
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
    val text = stringResource(
        id = if (isFocused) {
            R.string.free_focus
        } else {
            R.string.bring_focus_tap
        }
    )
    Column {
        Text(
            text = text,
            modifier = Modifier
                .focusRequester(focusRequester)
                .focusable(interactionSource = interactionSource)
        )
        Button(onClick = { focusRequester.requestFocus() }) {
            Text(stringResource(id = R.string.bring_focus_text))
        }
    }
}