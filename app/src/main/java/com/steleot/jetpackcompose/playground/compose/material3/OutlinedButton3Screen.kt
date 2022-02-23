package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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

private const val Url = "material3/OutlinedButton3Screen.kt"

@Composable
fun OutlinedButton3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.OutlinedButton3,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultOutlinedButton()
            CutCornerShapeOutlinedButton()
            RoundedCornerShapeOutlinedButton()
            ContainerColorOutlinedButton()
            ContentColorOutlinedButton()
            DisabledContentColorOutlinedButton()
            ContentPaddingOutlinedButton()
            BorderOutlinedButton()
            DisabledOutlinedButton()
        }
    }
}

@Preview
@Composable
private fun DefaultOutlinedButton() {
    OutlinedButton(
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
private fun CutCornerShapeOutlinedButton() {
    OutlinedButton(
        onClick = {},
        shape = CutCornerShape(12.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
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
private fun RoundedCornerShapeOutlinedButton() {
    OutlinedButton(
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
private fun ContainerColorOutlinedButton() {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
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
private fun ContentColorOutlinedButton() {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
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
private fun DisabledContentColorOutlinedButton() {
    OutlinedButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
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
private fun ContentPaddingOutlinedButton() {
    OutlinedButton(
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
private fun BorderOutlinedButton() {
    OutlinedButton(
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
private fun DisabledOutlinedButton() {
    OutlinedButton(
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