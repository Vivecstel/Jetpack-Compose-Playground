package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/OutlinedCardScreen.kt"

@Composable
fun OutlinedCardScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.OutlinedCard,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultOutlinedCard()
            ShapeOutlinedCard()
            ContainerColorOutlinedCard()
            ContentColorOutlinedCard()
            BorderOutlinedCard()
            ElevationOutlinedCard()
        }
    }
}

@Composable
private fun DefaultOutlinedCard() {
    OutlinedCard {
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

@Composable
private fun ShapeOutlinedCard() {
    OutlinedCard(
        shape = CutCornerShape(12.dp)
    ) {
        DefaultText()
    }
}

@Composable
private fun ContainerColorOutlinedCard() {
    OutlinedCard(
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.LightGray
        )
    ) {
        DefaultText()
    }
}

@Composable
private fun ContentColorOutlinedCard() {
    OutlinedCard(
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
    ) {
        DefaultText()
    }
}

@Composable
private fun BorderOutlinedCard() {
    OutlinedCard(
        border = BorderStroke(2.dp, Color.Black)
    ) {
        DefaultText()
    }
}

@Composable
private fun ElevationOutlinedCard() {
    OutlinedCard(
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 12.dp)
    ) {
        DefaultText()
    }
}
