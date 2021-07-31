package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.zachklipp.richtext.ui.slideshow.BodySlide
import com.zachklipp.richtext.ui.slideshow.Slideshow
import com.zachklipp.richtext.ui.slideshow.TitleSlide

private const val Url = "external/ComposeRichTextSlideshowScreen.kt"

@Composable
fun ComposeRichTextSlideshowScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextSlideshow,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SlideShowExample()
        }
    }
}

@Composable
private fun SlideShowExample() {
    Slideshow(
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
    )
}