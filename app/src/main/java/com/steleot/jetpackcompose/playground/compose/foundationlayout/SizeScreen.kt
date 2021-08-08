package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundationlayout/SizeScreen.kt"

@Composable
fun SizeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Border,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LastSizeBox()
            LastWidthBox()
            LastHeightBox()
            SizeBox()
            WidthBox()
            HeightBox()
            FillWidthBox()
            FillHalfWidthBox()
            FillHeightBox()
            FillHalfHeightBox()
            FillSizeModifier()
            FillHalfSizeModifier()
            WrapContentAlignedBox()
            WrapContentVerticallyAlignedBox()
            WrapContentHorizontallyAlignedBox()
        }
    }
}

@Preview
@Composable
private fun LastSizeBox() {
    Box(
        Modifier
            .requiredSize(100.dp, 100.dp)
            .requiredSize(50.dp, 50.dp)
            .background(Color.Red)
    )
}

@Preview
@Composable
private fun LastWidthBox() {
    Box(
        Modifier
            .requiredWidth(100.dp)
            .requiredWidth(50.dp)
            .aspectRatio(1f)
            .background(Color.Magenta)
    )
}

@Preview
@Composable
private fun LastHeightBox() {
    Box(
        Modifier
            .requiredHeight(100.dp)
            .requiredHeight(50.dp)
            .aspectRatio(1f)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun SizeBox() {
    Box {
        Box(
            Modifier
                .requiredSize(100.dp, 100.dp)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
private fun WidthBox() {
    Box {
        Box(
            Modifier
                .requiredWidth(100.dp)
                .aspectRatio(1f)
                .background(Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun HeightBox() {
    Box {
        Box(
            Modifier
                .requiredHeight(100.dp)
                .aspectRatio(1f)
                .background(Color.Blue)
        )
    }
}

@Preview
@Composable
private fun FillWidthBox() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .requiredSize(100.dp)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillHalfWidthBox() {
    Box(
        Modifier
            .requiredSize(100.dp)
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .fillMaxWidth(fraction = 0.5f)
                .requiredHeight(30.dp)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillHeightBox() {
    Box(
        Modifier
            .fillMaxHeight()
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .requiredSize(100.dp)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillHalfHeightBox() {
    Box(
        Modifier
            .requiredSize(100.dp)
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        // The inner Box will be (30.dp x 50.dp).
        Box(
            Modifier
                .requiredWidth(30.dp)
                .fillMaxHeight(0.5f)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillSizeModifier() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .requiredSize(100.dp)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillHalfSizeModifier() {
    Box(
        Modifier
            .requiredSize(100.dp)
            .background(Color.Red), contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .requiredWidth(30.dp)
                .fillMaxSize(0.5f)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun WrapContentAlignedBox() {
    Box(
        Modifier
            .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
            .wrapContentSize(Alignment.TopCenter)
            .requiredSize(20.dp)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun WrapContentVerticallyAlignedBox() {
    Box(
        Modifier
            .requiredSize(50.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .requiredHeight(20.dp)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun WrapContentHorizontallyAlignedBox() {
    Box(
        Modifier
            .requiredSize(50.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .requiredWidth(20.dp)
            .background(Color.Blue)
    )
}
