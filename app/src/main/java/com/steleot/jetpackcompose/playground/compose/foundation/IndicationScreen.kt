package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun IndicationScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Indication.capitalize(Locale.getDefault())
    ) {
        val interactionSource = remember { InteractionState() }
        Column {
            Text(
                text = "Click me and my neighbour will indicate as well!",
                modifier = Modifier
                    .clickable(
                        interactionState = interactionSource,
                        indication = rememberRipple()
                    ) { }
                    .padding(10.dp)
            )
            Spacer(Modifier.preferredSize(10.dp))
            Text(
                text = "I'm neighbour and I indicate when you click the other one",
                modifier = Modifier
                    .indication(interactionSource, LocalIndication.current)
                    .padding(10.dp)
            )
        }
    }
}
