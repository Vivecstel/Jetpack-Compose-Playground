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
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.OutlinedButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/OutlinedButtonScreen.kt"

@Composable
fun OutlinedButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.OutlinedButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultOutlinedButton()
            CutCornerShapeOutlinedButton()
            RoundedCornerShapeOutlinedButton()
            BackgroundColorOutlinedButton()
            ContentColorOutlinedButton()
            DisabledContentColorOutlinedButton()
            ContentPaddingOutlinedButton()
            ElevationPaddingOutlinedButton()
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
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
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
private fun BackgroundColorOutlinedButton() {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
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
private fun ElevationPaddingOutlinedButton() {
    OutlinedButton(
        onClick = {},
        elevation = ButtonDefaults.elevation(
            defaultElevation = 4.dp,
            pressedElevation = 4.dp,
            disabledElevation = 4.dp,
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
