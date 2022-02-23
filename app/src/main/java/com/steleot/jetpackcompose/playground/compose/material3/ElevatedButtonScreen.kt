package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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

private const val Url = "material3/ElevatedButtonScreen.kt"

@Composable
fun ElevatedButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.ElevatedButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultElevatedButton()
            CutCornerShapeElevatedButton()
            RoundedCornerShapeElevatedButton()
            ContainerColorElevatedButton()
            ContentColorElevatedButton()
            DisabledBackgroundColorElevatedButton()
            DisabledContentColorElevatedButton()
            ContentPaddingElevatedButton()
            ElevationPaddingElevatedButton()
            BorderElevatedButton()
            DisabledElevatedButton()
        }
    }
}

@Composable
private fun DefaultElevatedButton() {
    ElevatedButton(
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
private fun CutCornerShapeElevatedButton() {
    ElevatedButton(
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
private fun RoundedCornerShapeElevatedButton() {
    ElevatedButton(
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
private fun ContainerColorElevatedButton() {
    ElevatedButton(
        onClick = {},
        colors = ButtonDefaults.elevatedButtonColors(
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
private fun ContentColorElevatedButton() {
    ElevatedButton(
        onClick = {},
        colors = ButtonDefaults.elevatedButtonColors(
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
private fun DisabledBackgroundColorElevatedButton() {
    ElevatedButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.elevatedButtonColors(
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
private fun DisabledContentColorElevatedButton() {
    ElevatedButton(
        enabled = false,
        onClick = {},
        colors = ButtonDefaults.elevatedButtonColors(
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
private fun ContentPaddingElevatedButton() {
    ElevatedButton(
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
private fun ElevationPaddingElevatedButton() {
    ElevatedButton(
        onClick = {},
        elevation = ButtonDefaults.elevatedButtonElevation(
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
private fun BorderElevatedButton() {
    ElevatedButton(
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
private fun DisabledElevatedButton() {
    ElevatedButton(
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