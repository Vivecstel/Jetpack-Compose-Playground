package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/BadgedBoxScreen.kt"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BadgedBoxScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BadgedBox,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            BottomNavigation {
                BottomNavigationItem(
                    icon = {
                        BadgedBox(badge = { Text("8") }) {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Favorite"
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