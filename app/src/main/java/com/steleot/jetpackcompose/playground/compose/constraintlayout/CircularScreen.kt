package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes

private const val Url = "constraintlayout/CircularScreen.kt"

@Composable
fun CircularScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.Circular,
        link = Url,
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
            Icon(Icons.Default.Menu, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab2) {
                circular(fab1, 72.0f, 100.dp)
            }
        ) {
            Icon(Icons.Default.MenuOpen, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab3) {
                circular(fab1, 144.0f, 100.dp)
            }
        ) {
            Icon(Icons.Default.MenuBook, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab4) {
                circular(fab1, 216.0f, 100.dp)
            }
        ) {
            Icon(Icons.Default.RestaurantMenu, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab5) {
                circular(fab1, 288.0f, 100.dp)
            }
        ) {
            Icon(Icons.Default.AddAlarm, contentDescription = null)
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.constrainAs(fab6) {
                circular(fab1, 360.0f, 100.dp)
            }
        ) {
            Icon(Icons.Default.AddBox, contentDescription = null)
        }
    }
}