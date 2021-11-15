package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
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