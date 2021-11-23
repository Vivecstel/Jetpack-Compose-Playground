package com.steleot.jetpackcompose.playground.compose.reusable

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.LocalThemeState
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme3
import androidx.compose.material3.Scaffold as Scaffold3

@Composable
fun DefaultScaffold(
    topBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val context = LocalContext.current
    val inAppReviewer = LocalInAppReviewer.current
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = topBar,
        content = content,
    )
    LaunchedEffect(Unit) {
        if (context is Activity) inAppReviewer.requestReview(context)
    }
}

@Composable
fun DefaultScaffold(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = title,
                link = link,
            )
        },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultScaffold3(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    val themeState = LocalThemeState.current
    val context = LocalContext.current
    val inAppReviewer = LocalInAppReviewer.current
    JetpackComposePlaygroundTheme3(
        themeState = themeState
    ) {
        Scaffold3(
            modifier = Modifier.systemBarsPadding(),
            topBar = {
                DefaultSmallTopAppBar(title = title, link = link)
            },
            content = content
        )
    }
    LaunchedEffect(Unit) {
        if (context is Activity) inAppReviewer.requestReview(context)
    }
}
