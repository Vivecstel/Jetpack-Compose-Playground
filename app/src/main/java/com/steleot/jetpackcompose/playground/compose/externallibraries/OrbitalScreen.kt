package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/OrbitalScreen.kt"

@Composable
fun OrbitalScreen() { // todo stelios
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Orbital,
        link = URL,
    ) {
//        OrbitalExample()
    }
}

//private val imageURL = randomSampleImageUrl()
//
//@Composable
//private fun OrbitalExample() {
//    val movementSpec = SpringSpec<IntOffset>(
//        dampingRatio = Spring.DampingRatioMediumBouncy,
//        stiffness = 200f
//    )
//
//    var isTransformed by rememberSaveable { mutableStateOf(false) }
//    val poster = rememberContentWithOrbitalScope {
//        AsyncImage(
//            model = imageURL,
//            contentDescription = null,
//            modifier = if (isTransformed) {
//                Modifier.size(360.dp, 620.dp)
//            } else {
//                Modifier.size(130.dp, 220.dp)
//            }.animateMovement(this, movementSpec),
//            contentScale = ContentScale.Fit
//        )
//    }
//
//    Orbital(
//        modifier = Modifier
//            .clickable { isTransformed = !isTransformed }
//    ) {
//        if (isTransformed) {
//            Column(
//                Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                poster()
//            }
//        } else {
//            Column(
//                Modifier
//                    .fillMaxSize()
//                    .padding(20.dp),
//                horizontalAlignment = Alignment.End,
//                verticalArrangement = Arrangement.Bottom
//            ) {
//                poster()
//            }
//        }
//    }
//}
