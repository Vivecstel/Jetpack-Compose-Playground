package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Preview
@Composable
fun PrimitiveScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Primitive.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(integerResource(id = R.integer.integer_resource)) {
                Text(text = it.toString())
            }

            integerArrayResource(id = R.array.integer_array).forEach {
                Text(
                    text = it.toString(),
                    modifier = Modifier.padding(16.dp)
                )
            }

            Text(
                text = "Boolean resource: ${booleanResource(id = R.bool.boolean_resource)}",
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Padding from dimension resource",
                modifier = Modifier.padding(dimensionResource(id = R.dimen.dimen_resource))
            )
        }
    }
}
