package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter

// todo stelios
@Composable
fun DefaultListItem(
    text: String,
    modifier: Modifier = Modifier,
    cardClickAction: () -> Unit = {},
) {
    DefaultListItem(
        AnnotatedString(text.capitalizeFirstLetter()), modifier, cardClickAction
    )
}

// todo stelios
@Composable
fun DefaultListItem(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    cardClickAction: () -> Unit = {},
) {
    Card(
        backgroundPainter = ColorPainter(MaterialTheme.colors.primary),
        onClick = cardClickAction,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
            modifier = modifier.padding(8.dp)
        )
    }
}