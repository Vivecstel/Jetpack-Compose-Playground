package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SpacerScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Spacer.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Text(
                text = "There"
            )
            Spacer(modifier = Modifier.requiredHeight(16.dp))
            Text(
                text = "is"
            )
            Spacer(modifier = Modifier.requiredHeight(32.dp))
            Text(
                text = "spacer"
            )
            Spacer(modifier = Modifier.requiredHeight(16.dp))
            Row {
                Text(
                    text = "between"
                )
                Spacer(modifier = Modifier.requiredWidth(16.dp))
                Text(
                    text = "even"
                )
                Spacer(modifier = Modifier.requiredWidth(16.dp))
                Text(
                    text = "in"
                )
                Spacer(modifier = Modifier.requiredWidth(32.dp))
                Text(
                    text = "row"
                )
                Spacer(modifier = Modifier.requiredWidth(16.dp))
            }
        }
    }
}