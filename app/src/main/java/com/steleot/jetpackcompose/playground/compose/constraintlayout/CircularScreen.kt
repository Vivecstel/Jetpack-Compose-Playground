package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.FloatingActionButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.navigation.graph.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "constraintlayout/CircularScreen.kt"

@Composable
fun CircularScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.Circular,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularExample()
        }
    }
}

@Composable
private fun CircularExample() {
    ConstraintLayout {
        val (fab1, fab2, fab3, fab4, fab5, fab6) = createRefs()

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab1) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }
        ) {
            Icon(Icons.Filled.Menu, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab2) {
                circular(fab1, 72.0f, 100.dp)
            }
        ) {
            Icon(Icons.Filled.MenuOpen, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab3) {
                circular(fab1, 144.0f, 100.dp)
            }
        ) {
            Icon(Icons.Filled.MenuBook, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab4) {
                circular(fab1, 216.0f, 100.dp)
            }
        ) {
            Icon(Icons.Filled.RestaurantMenu, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab5) {
                circular(fab1, 288.0f, 100.dp)
            }
        ) {
            Icon(Icons.Filled.AddAlarm, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab6) {
                circular(fab1, 360.0f, 100.dp)
            }
        ) {
            Icon(Icons.Filled.AddBox, contentDescription = null)
        }
    }
}