package com.steleot.jetpackcompose.playground.ui.base.material3

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter

@Composable
fun TitleText(
    title: String,
) {
    Text(
        text = title.capitalizeFirstLetter(),
        style = MaterialTheme.typography.titleLarge,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
