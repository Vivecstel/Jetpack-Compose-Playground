package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import androidx.compose.material3.MaterialTheme as MaterialTheme3
import androidx.compose.material3.Text as Text3

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
fun TitleText3(
    title: String,
) {
    Text3(
        text = title.capitalizeFirstLetter(),
        style = MaterialTheme3.typography.titleLarge,
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