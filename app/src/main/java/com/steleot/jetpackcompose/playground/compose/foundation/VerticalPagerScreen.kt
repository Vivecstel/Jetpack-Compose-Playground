package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/VerticalPagerScreen.kt"

@Composable
fun VerticalPagerScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.VerticalPager,
        link = URL,
    ) {
        VerticalPagerExample(paddingValues = it)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun VerticalPagerExample(paddingValues: PaddingValues) {
    val state = rememberPagerState { 10 }
    VerticalPager(
        state = state,
        modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues)
    ) { page ->
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(color = MaterialTheme.colors.primary)
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = page.toString(), fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}