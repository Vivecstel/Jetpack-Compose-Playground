package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val Url = "externallibraries/RatingBarScreen.kt"

@Composable
fun RatingBarScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.RatingBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultRatingBar()
            HighlightedRatingBar()
        }
    }
}

@Composable
private fun DefaultRatingBar() {
    var value: Float by rememberSaveable { mutableStateOf(3.5f) }
    RatingBar(
        value = value,
        onValueChange = {
            value = it
        },
        onRatingChanged = {
            Timber.d("Rating change to $it")
        }
    )
}

@Composable
private fun HighlightedRatingBar() {
    var value: Float by rememberSaveable { mutableStateOf(3f) }
    RatingBar(

        config = RatingBarConfig().apply {
            numStars(6)
            size(32.dp)
            padding(8.dp)
            style(RatingBarStyle.HighLighted)
        },
        value = value,
        onValueChange = {
            value = it
        },
        onRatingChanged = {
            Timber.d("Rating change to $it")
        },
    )
}