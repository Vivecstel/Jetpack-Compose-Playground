package com.steleot.jetpackcompose.playground.ui.base.material3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.theme.material3.JetpackComposePlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultScaffold(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    // todo stelios
//    val themeState = LocalThemeState.current
    val context = LocalContext.current
//    val inAppReviewer = LocalInAppReviewer.current
    JetpackComposePlaygroundTheme(
//        themeState = themeState
    ) {
        Scaffold(
            modifier = Modifier.systemBarsPadding(),
            topBar = {
                DefaultSmallTopAppBar(title = title, link = link)
            },
            content = content
        )
    }
    // todo stelios
//    LaunchedEffect(Unit) {
//        if (context is Activity) inAppReviewer.requestReview(context)
//    }
}