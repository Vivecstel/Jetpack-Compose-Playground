package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.CurvedRow
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

@Composable
fun CurvedRowScreen() {
    Column {
        Text(text = FoundationNavRoutes.CurvedRow)
        CurvedRow {
            Text(
                "Simple",
                Modifier
                    .background(MaterialTheme.colors.primary)
                    .padding(2.dp),
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(MaterialTheme.colors.secondary)
            )
            Text(
                "CurvedRow",
                Modifier
                    .background(MaterialTheme.colors.primary)
                    .padding(2.dp),
            )
        }
    }
}