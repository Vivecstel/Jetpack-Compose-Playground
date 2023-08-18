package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "externallibraries/RatingBarScreen.kt"

@Composable
fun RatingBarScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.RatingBar,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultRatingBar()
            FillRatingBar()
        }
    }
}

@Composable
private fun DefaultRatingBar() {
    var value: Float by rememberSaveable { mutableFloatStateOf(3.5f) }
    RatingBar(
        value = value,
        style = RatingBarStyle.Default,
        onValueChange = {
            value = it
        },
        onRatingChanged = {
            Timber.d("Rating change to $it")
        }
    )
}

@Composable
private fun FillRatingBar() {
    var value: Float by rememberSaveable { mutableFloatStateOf(3f) }
    RatingBar(
        value = value,
        style = RatingBarStyle.Fill(),
        onValueChange = {
            value = it
        },
        numOfStars = 6,
        size = 32.dp,
        spaceBetween = 8.dp,
        onRatingChanged = {
            Timber.d("Rating change to $it")
        },
    )
}