package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/ComposeRichTextSlideshowScreen.kt"

@Composable
fun ComposeRichTextSlideshowScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextSlideshow,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SlideShowExample()
        }
    }
}

@Composable
private fun SlideShowExample() {
    /*Slideshow(
        {
            TitleSlide(
                title = { Text("Title") },
                subtitle = { Text("Subtitle") },
            )
        },
        {
            BodySlide(
                header = { Text("Header") },
                footer = { Text("Footer") },
                body = { Text("Body") },
            )
        }
    )*/
}