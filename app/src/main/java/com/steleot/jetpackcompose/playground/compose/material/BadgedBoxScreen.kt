package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/BadgedBoxScreen.kt"

@Composable
fun BadgedBoxScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BadgedBox,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            BottomNavigation {
                BottomNavigationItem(
                    icon = {
                        BadgedBox(badge = { Badge { Text("8") } }) {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = stringResource(id = R.string.favorite)
                            )
                        }
                    },
                    selected = false,
                    onClick = {}
                )
            }
        }
    }
}