package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSizeConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SizeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Border.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp).verticalScroll(rememberScrollState()),
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
            MinSizeBox()
        }
    }
}

@Preview
@Composable
private fun LastSizeBox() {
    Box(
        Modifier
            .size(100.dp, 100.dp)
            .size(50.dp, 50.dp)
            .background(Color.Red)
    )
}

@Preview
@Composable
private fun LastWidthBox() {
    Box(
        Modifier
            .width(100.dp)
            .width(50.dp)
            .aspectRatio(1f)
            .background(Color.Magenta)
    )
}

@Preview
@Composable
private fun LastHeightBox() {
    Box(
        Modifier
            .height(100.dp)
            .height(50.dp)
            .aspectRatio(1f)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun SizeBox() {
    Box {
        Box(Modifier.size(100.dp, 100.dp).background(Color.Red))
    }
}

@Preview
@Composable
private fun WidthBox() {
    Box {
        Box(Modifier.width(100.dp).aspectRatio(1f).background(Color.Magenta))
    }
}

@Preview
@Composable
private fun HeightBox() {
    Box {
        Box(Modifier.height(100.dp).aspectRatio(1f).background(Color.Blue))
    }
}

@Preview
@Composable
private fun FillWidthBox() {
    Box(Modifier.fillMaxWidth().background(Color.Red), contentAlignment = Alignment.Center) {
        Box(Modifier.size(100.dp).background(color = Color.Magenta))
    }
}

@Preview
@Composable
private fun FillHalfWidthBox() {
    Box(Modifier.size(100.dp).background(Color.Red), contentAlignment = Alignment.Center) {
        Box(
            Modifier.fillMaxWidth(fraction = 0.5f)
                .height(30.dp)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillHeightBox() {
    Box(Modifier.fillMaxHeight().background(Color.Red), contentAlignment = Alignment.Center) {
        Box(Modifier.size(100.dp).background(color = Color.Magenta))
    }
}

@Preview
@Composable
private fun FillHalfHeightBox() {
    Box(Modifier.size(100.dp).background(Color.Red), contentAlignment = Alignment.Center) {
        // The inner Box will be (30.dp x 50.dp).
        Box(
            Modifier.width(30.dp)
                .fillMaxHeight(0.5f)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun FillSizeModifier() {
    Box(Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center) {
        Box(Modifier.size(100.dp).background(color = Color.Magenta))
    }
}

@Preview
@Composable
private fun FillHalfSizeModifier() {
    Box(Modifier.size(100.dp).background(Color.Red), contentAlignment = Alignment.Center) {
        Box(
            Modifier.width(30.dp)
                .fillMaxSize(0.5f)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
private fun WrapContentAlignedBox() {
    Box(
        Modifier.sizeIn(minWidth = 40.dp, minHeight = 40.dp)
            .wrapContentSize(Alignment.TopCenter)
            .size(20.dp)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun WrapContentVerticallyAlignedBox() {
    Box(
        Modifier.size(50.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .height(20.dp)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun WrapContentHorizontallyAlignedBox() {
    Box(
        Modifier.size(50.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .width(20.dp)
            .background(Color.Blue)
    )
}

@Preview
@Composable
private fun MinSizeBox() {
    @Composable
    fun DefaultMinBox(modifier: Modifier = Modifier) {
        Box(
            modifier.defaultMinSizeConstraints(minWidth = 100.dp, minHeight = 100.dp)
                .background(Color.Blue)
        )
    }
    DefaultMinBox()
    DefaultMinBox(Modifier.sizeIn(minWidth = 50.dp, minHeight = 50.dp))
}
