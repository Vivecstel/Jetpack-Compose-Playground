package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter

@Composable
fun DefaultCardListItem(
    text: String,
    hasRibbon: Boolean = false,
    cardClickAction: () -> Unit = {},
) {
    DefaultCardListItem(
        text = AnnotatedString(
            text.capitalizeFirstLetter()
        ),
        hasRibbon = hasRibbon,
        cardClickAction = cardClickAction
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultCardListItem(
    text: AnnotatedString,
    secondaryText: AnnotatedString? = null,
    hasRibbon: Boolean = false,
    cardClickAction: () -> Unit = {},
) {
    with(LocalDensity.current) {
        val offset = 28.dp.toPx()
        val secondaryColor = MaterialTheme.colors.secondary
        Card(
            onClick = cardClickAction,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.primary
        ) {
            DefaultListItem(
                text = text,
                secondaryText = secondaryText,
            ) {
                if (hasRibbon) {
                    Canvas(
                        modifier = Modifier
                            .height(48.dp)
                            .width(15.dp)
                    ) {
                        drawPath(
                            getRibbonPath(size.width, size.height - offset),
                            secondaryColor
                        )
                    }
                }
            }
        }
    }
}