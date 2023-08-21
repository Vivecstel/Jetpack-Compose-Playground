package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/BasicMarqueeScreen.kt"

@Composable
fun BasicMarqueeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.BasicMarquee,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultBasicMarquee()
            WhileFocusedBasicMarquee()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DefaultBasicMarquee() {
    Box(modifier = Modifier.width(50.dp)) {
        Text(
            stringResource(id = R.string.app_name),
            modifier = Modifier.basicMarquee()
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun WhileFocusedBasicMarquee() {
    val focusRequester = remember { FocusRequester() }
    Box(modifier = Modifier.width(50.dp)) {
        Text(
            stringResource(id = R.string.app_name),
            modifier = Modifier
                .clickable { focusRequester.requestFocus() }
                .basicMarquee(animationMode = MarqueeAnimationMode.WhileFocused)
                .focusRequester(focusRequester = focusRequester)
                .focusable()
        )
    }
}
