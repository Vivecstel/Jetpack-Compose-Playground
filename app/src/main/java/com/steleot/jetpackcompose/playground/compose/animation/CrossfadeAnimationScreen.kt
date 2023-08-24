package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "animation/CrossfadeAnimationScreen.kt"

@Composable
fun CrossfadeAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.CrossfadeAnimation,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CrossfadeTextAnimation()
            CrossfadeColorAnimation()
        }
    }
}

@Composable
private fun CrossfadeTextAnimation() {
    val strings = listOf(
        stringResource(id = R.string.first_text),
        stringResource(id = R.string.second_text)
    )
    val current = remember { mutableStateOf(strings[0]) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Crossfade(
            targetState = current,
            label = "CrossfadeTextAnimation",
        ) {
            Text(
                text = it.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        current.value =
                            if (current.value == strings[0]) strings[1] else strings[0]
                    }),
                style = TextStyle(textAlign = TextAlign.Center)
            )
        }
    }
}

@Composable
private fun CrossfadeColorAnimation() {
    val colors = listOf(Color.Red, Color.Green)
    val current = remember { mutableStateOf(colors[0]) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Crossfade(
            targetState = current,
            label = "CrossfadeColorAnimation",
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable(onClick = {
                        current.value = if (it.value == colors[0]) colors[1] else colors[0]
                    })
                    .background(current.value)
            )
        }
    }
}