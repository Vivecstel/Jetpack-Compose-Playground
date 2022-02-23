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
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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

private const val Url = "material/TextButtonScreen.kt"

@Composable
fun TextButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.TextButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultTextButton()
            CutCornerShapeTextButton()
            RoundedCornerShapeTextButton()
            BackgroundColorTextButton()
            ContentColorTextButton()
            DisabledContentColorTextButton()
            ContentPaddingTextButton()
            ElevationPaddingTextButton()
            BorderTextButton()
            DisabledTextButton()
        }
    }
}

@Preview
@Composable
private fun DefaultTextButton() {
    TextButton(
        onClick = {},
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun CutCornerShapeTextButton() {
    TextButton(
        onClick = {},
        shape = CutCornerShape(12.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun RoundedCornerShapeTextButton() {
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun BackgroundColorTextButton() {
    TextButton(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Red
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun ContentColorTextButton() {
    TextButton(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Cyan
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun DisabledContentColorTextButton() {
    TextButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            disabledContentColor = Color.Magenta,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun ContentPaddingTextButton() {
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(32.dp),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun ElevationPaddingTextButton() {
    TextButton(
        onClick = {},
        elevation = ButtonDefaults.elevation(
            defaultElevation = 4.dp,
            pressedElevation = 4.dp,
            disabledElevation = 4.dp,
        ),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Red,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun BorderTextButton() {
    TextButton(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun DisabledTextButton() {
    TextButton(
        onClick = {},
        enabled = true,
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}
