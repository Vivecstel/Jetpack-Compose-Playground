package com.steleot.jetpackcompose.playground.compose.externallibraries

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.orchestra.colorpicker.AlphaSlideBar
import com.skydoves.orchestra.colorpicker.AlphaTileBox
import com.skydoves.orchestra.colorpicker.BrightnessSlideBar
import com.skydoves.orchestra.colorpicker.ColorPicker
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/OrchestraColorPickerScreen.kt"

@Composable
fun OrchestraColorPickerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraColorPicker,
        link = Url,
    ) {
        OrchestraColorPickerExample()
    }
}

@Composable
private fun OrchestraColorPickerExample() {
    var selectedColor by remember { mutableStateOf(ColorEnvelope(0)) }
    val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 40.dp)
                .fillMaxSize()
        ) {
            val (colorPicker, square, colorCode) = createRefs()
            ColorPicker(
                modifier = Modifier
                    .constrainAs(colorPicker) {
                        if (isPortrait) {
                            centerHorizontallyTo(parent)
                        } else {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                    }
                    .then(
                        if (isPortrait) Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                        else Modifier.size(
                            200.dp
                        )
                    ),
                onColorListener = { envelope, _ ->
                    selectedColor = envelope
                },
                initialColor = MaterialTheme.colors.primary,
                children = { colorPickerView ->
                    if (isPortrait) {
                        Column(modifier = Modifier.padding(top = 32.dp)) {
                            Box(modifier = Modifier.padding(vertical = 6.dp)) {
                                AlphaSlideBar(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    colorPickerView = colorPickerView
                                )
                            }
                            Box(modifier = Modifier.padding(vertical = 6.dp)) {
                                BrightnessSlideBar(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    colorPickerView = colorPickerView
                                )
                            }
                        }
                    }
                }
            )
            AlphaTileBox(
                modifier = Modifier
                    .constrainAs(square) {
                        centerHorizontallyTo(parent)
                        bottom.linkTo(parent.bottom)
                        if (!isPortrait) {
                            top.linkTo(parent.top)
                        }
                    }
                    .size(32.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                it.setBackgroundColor(selectedColor.color)
            }
            Text(
                text = "#${selectedColor.hexCode}",
                style = MaterialTheme.typography.h4.copy(
                    color = MaterialTheme.colors.onBackground
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(colorCode) {
                        centerHorizontallyTo(parent)
                        if (isPortrait) {
                            bottom.linkTo(square.top)
                        } else {
                            top.linkTo(square.bottom)
                        }
                    }
                    .padding(8.dp)
            )
        }
    }
}