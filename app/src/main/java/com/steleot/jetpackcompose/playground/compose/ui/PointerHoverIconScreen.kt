package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.resources.R

private const val URL = "ui/PluralStringScreen.kt"

@Composable
fun PointerHoverIconScreen() {
    DefaultScaffold(
        title = UiNavRoutes.PointerHoverIcon,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectionContainer {
                Column {
                    Text(stringResource(id = R.string.selectable_text))
                    Text(
                        modifier = Modifier.pointerHoverIcon(
                            icon = PointerIcon.Hand,
                            overrideDescendants = true
                        ),
                        text = stringResource(id = R.string.selectable_text_with_hand)
                    )
                }
            } }
    }
}