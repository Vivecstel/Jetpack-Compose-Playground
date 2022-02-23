package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/CardScreen.kt"

@Composable
fun CardScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Card,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultCard()
            ShapeCard()
            BackgroundColorCard()
            ContentColorCard()
            BorderCard()
            ElevationCard()
        }
    }
}

@Preview
@Composable
private fun DefaultCard() {
    Card {
        DefaultText()
    }
}

@Composable
private fun DefaultText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
private fun ShapeCard() {
    Card(
        shape = CutCornerShape(12.dp)
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun BackgroundColorCard() {
    Card(
        backgroundColor = Color.LightGray
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun ContentColorCard() {
    Card(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun BorderCard() {
    Card(
        border = BorderStroke(2.dp, Color.Black)
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun ElevationCard() {
    Card(
        elevation = 12.dp
    ) {
        DefaultText()
    }
}
