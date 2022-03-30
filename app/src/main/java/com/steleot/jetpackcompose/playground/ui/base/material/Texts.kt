package com.steleot.jetpackcompose.playground.ui.base.material

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter

@Composable
fun TitleText(
    title: String,
) {
    Text(
        text = title.capitalizeFirstLetter(),
        style = MaterialTheme.typography.h6,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun BoxScope.ErrorText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        fontWeight = FontWeight.Bold,
        modifier = modifier.align(Alignment.Center)
    )
}