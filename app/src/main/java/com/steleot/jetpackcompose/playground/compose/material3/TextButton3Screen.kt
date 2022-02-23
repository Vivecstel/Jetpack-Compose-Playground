package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/TextButton3Screen.kt"

@Composable
fun TextButton3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.TextButton3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultTextButton()
            CutCornerShapeTextButton()
            RoundedCornerShapeTextButton()
            BackgroundColorTextButton()
            ContentColorTextButton()
            DisabledContentColorTextButton()
            ContentPaddingTextButton()
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
            containerColor = Color.Red
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
