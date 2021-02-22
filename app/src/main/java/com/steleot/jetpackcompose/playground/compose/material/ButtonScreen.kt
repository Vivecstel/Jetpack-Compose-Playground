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
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Button.capitalize(Locale.getDefault())
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
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
            OutlinedDefaultButton()
            TextDefaultButton()
        }
    }
}

@Preview
@Composable
private fun DefaultButton() {
    Button(
        onClick = {},
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = "Default Button",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun CutCornerShapeButton() {
    Button(
        onClick = {},
        shape = CutCornerShape(12.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "Cut Corner Shape Button",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun RoundedCornerShapeButton() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "Rounded Corner Shape Button",
            modifier = Modifier.padding(8.dp)
        )
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
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "Background Color Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Content Color Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Disabled Background Color Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Disabled Content Color Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Content Padding Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Elevation Padding Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Border Button",
            modifier = Modifier.padding(8.dp)
        )
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
        Text(
            text = "Disabled Button",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun OutlinedDefaultButton() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "Outlined Button",
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun TextDefaultButton() {
    TextButton(
        onClick = {},
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "Text Button",
            modifier = Modifier.padding(8.dp)
        )
    }
}
