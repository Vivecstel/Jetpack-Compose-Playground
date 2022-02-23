package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

private const val Url = "material3/Button3Screen.kt"

@Composable
fun Button3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.Button3,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultButton()
            CutCornerShapeButton()
            RoundedCornerShapeButton()
            ContainerColorButton()
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

@Composable
private fun DefaultButton() {
    Button(
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
private fun CutCornerShapeButton() {
    Button(
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
private fun RoundedCornerShapeButton() {
    Button(
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
private fun ContainerColorButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
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
private fun ContentColorButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
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
private fun DisabledBackgroundColorButton() {
    Button(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.buttonColors(
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
private fun DisabledContentColorButton() {
    Button(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.buttonColors(
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
private fun ContentPaddingButton() {
    Button(
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
private fun ElevationPaddingButton() {
    Button(
        onClick = {},
        elevation = ButtonDefaults.buttonElevation(
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
private fun BorderButton() {
    Button(
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
private fun DisabledButton() {
    Button(
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
