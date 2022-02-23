package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "foundation/SelectionContainerScreen.kt"

@Composable
fun SelectionContainerScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.SelectionContainer,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectionContainerExample()
            PartiallySelectableText()
        }
    }
}

@Composable
private fun SelectionContainerExample() {
    SelectionContainer {
        Text(stringResource(id = R.string.selectable_text))
    }
}

@Composable
private fun PartiallySelectableText() {
    SelectionContainer {
        Column {
            Text(stringResource(id = R.string.selectable_text))
            Text(stringResource(id = R.string.selectable_too))
            Text(stringResource(id = R.string.selectable_as_well))
            DisableSelection {
                Text(stringResource(id = R.string.not_selectable_text))
                Text(stringResource(id = R.string.neither_selectable_text))
            }
            Text(stringResource(id = R.string.selectable_again))
            Text(stringResource(id = R.string.selectable_this_too))
        }
    }
}