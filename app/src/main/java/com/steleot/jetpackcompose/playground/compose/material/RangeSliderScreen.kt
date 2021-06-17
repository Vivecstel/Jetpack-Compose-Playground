package com.steleot.jetpackcompose.playground.compose.material

//import androidx.compose.material.RangeSlider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "material/RangeSliderScreen.kt"

@Composable
fun RangeSliderScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.RangeSlider,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TODO()
        }
    }
}

//@Composable
//private fun DefaultRangeSlider() {
//    RangeSlider()
//}