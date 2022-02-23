package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/FilledTonalButtonScreen.kt"

@Composable
fun FilledTonalButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.FilledTonalButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultFilledTonalButton()
            CutCornerShapeFilledTonalButton()
            RoundedCornerShapeFilledTonalButton()
            ContainerColorFilledTonalButton()
            ContentColorFilledTonalButton()
            DisabledBackgroundColorFilledTonalButton()
            DisabledContentColorFilledTonalButton()
            ContentPaddingFilledTonalButton()
            ElevationPaddingFilledTonalButton()
            BorderFilledTonalButton()
            DisabledFilledTonalButton()
        }
    }
}

@Composable
private fun DefaultFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun CutCornerShapeFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        shape = CutCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun RoundedCornerShapeFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun ContainerColorFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = Color.Red
        ),
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun ContentColorFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            contentColor = Color.White
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun DisabledBackgroundColorFilledTonalButton() {
    FilledTonalButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            disabledContainerColor = Color.Gray
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun DisabledContentColorFilledTonalButton() {
    FilledTonalButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun ContentPaddingFilledTonalButton() {
    FilledTonalButton(
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

@Composable
private fun ElevationPaddingFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
        elevation = ButtonDefaults.filledTonalButtonElevation(
            defaultElevation = 12.dp,
            pressedElevation = 12.dp,
            disabledElevation = 2.dp,
        ),
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun BorderFilledTonalButton() {
    FilledTonalButton(
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

@Composable
private fun DisabledFilledTonalButton() {
    FilledTonalButton(
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