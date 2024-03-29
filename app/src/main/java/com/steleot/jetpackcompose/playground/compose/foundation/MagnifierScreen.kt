package com.steleot.jetpackcompose.playground.compose.foundation

import android.os.Build
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/MagnifierScreen.kt"

@Composable
fun MagnifierScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Magnifier,
        link = URL,
    ) {
        var magnifierCenter by remember { mutableStateOf(Offset.Unspecified) }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            Text(
                text = stringResource(id = R.string.magnifier_not_supported),
                modifier = Modifier.padding(all = 16.dp)
            )
        } else {
            val primaryColor = MaterialTheme.colors.primary
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues = it), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .magnifier(
                            sourceCenter = { magnifierCenter },
                            zoom = 2f
                        )
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDragStart = { offset -> magnifierCenter = offset },
                                onDrag = { _, delta -> magnifierCenter += delta },
                                onDragEnd = { magnifierCenter = Offset.Unspecified },
                                onDragCancel = { magnifierCenter = Offset.Unspecified },
                            )
                        }

                        .drawBehind {
                            for (diameter in 2 until size.maxDimension.toInt() step 10) {
                                drawCircle(
                                    color = primaryColor,
                                    radius = diameter / 2f,
                                    style = Stroke()
                                )
                            }
                        }
                )
            }
        }
    }
}
