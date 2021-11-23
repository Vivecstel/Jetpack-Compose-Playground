package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultListItem(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    secondaryText: AnnotatedString? = null,
    icon: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null
) {
    ListItem(
        modifier = modifier,
        secondaryText = if (secondaryText != null) {
            {
                Text(
                    secondaryText,
                    style = MaterialTheme.typography.caption,
                )
            }
        } else null,
        icon = icon,
        trailing = trailing
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
    }
}