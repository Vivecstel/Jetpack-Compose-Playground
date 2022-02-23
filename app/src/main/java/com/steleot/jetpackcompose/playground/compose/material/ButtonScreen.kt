package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/ButtonScreen.kt"

@Composable
fun ButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Button,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultButton()
            CutCornerShapeButton()
            RoundedCornerShapeButton()
            BackgroundColorButton()
            ContentColorButton()
            DisabledBackgroundColorButton()
            DisabledContentColorButton()
            ContentPaddingButton()
            ElevationPaddingButton()
            BorderButton()
            DisabledButton()
        }
    }
}

@Preview
@Composable
private fun DefaultButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(vertical = 4.dp)
            .testTag("Default Button")
    ) {
        DefaultText()
    }
}

@Composable
private fun DefaultText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
private fun CutCornerShapeButton() {
    Button(
        onClick = {},
        shape = CutCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .testTag("Cut Corner Shape Button"),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun RoundedCornerShapeButton() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .testTag("Rounded Corner Shape Button"),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun BackgroundColorButton() {
    Button(
        onClick = {},
        colors = buttonColors(
            backgroundColor = Color.Red
        ),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .testTag("Background Color Button"),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun ContentColorButton() {
    Button(
        onClick = {},
        colors = buttonColors(
            contentColor = Color.White
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun DisabledBackgroundColorButton() {
    Button(
        enabled = false,
        onClick = {},
        colors = buttonColors(
            disabledBackgroundColor = Color.Gray
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun DisabledContentColorButton() {
    Button(
        enabled = false,
        onClick = {},
        colors = buttonColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun ContentPaddingButton() {
    Button(
        onClick = {},
        contentPadding = PaddingValues(32.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun ElevationPaddingButton() {
    Button(
        onClick = {},
        elevation = elevation(
            defaultElevation = 12.dp,
            pressedElevation = 12.dp,
            disabledElevation = 2.dp,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun BorderButton() {
    Button(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}

@Preview
@Composable
private fun DisabledButton() {
    Button(
        onClick = {},
        enabled = true,
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        DefaultText()
    }
}
