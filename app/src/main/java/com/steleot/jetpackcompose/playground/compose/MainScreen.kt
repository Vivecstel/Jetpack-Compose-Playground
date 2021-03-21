package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.google.accompanist.insets.statusBarsPadding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar

private val routes = listOf(
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.Foundation,
    MainNavRoutes.FoundationLayout,
    MainNavRoutes.Material,
    MainNavRoutes.MaterialIcons,
    MainNavRoutes.MaterialIConsExtended,
    MainNavRoutes.Runtime,
    MainNavRoutes.Ui,
    MainNavRoutes.ViewModel,
    MainNavRoutes.ExternalLibraries,
)

@Composable
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.jetpack_compose_playground),
    list: List<String> = routes,
    showBackArrow: Boolean = false,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showAd: Boolean = false,
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = showBackArrow,
                navigateToSearch = navigateToSearch
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            list.forEach { item ->
                DefaultListItem(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navController.navigate(item)
                }
            }
            if (showAd) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(55.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    AdView()
                }
            }
        }
    }
}

@Composable
private fun AdView() {
    AndroidView(
        factory = { context ->
            AdView(context).apply {
                adSize = AdSize.BANNER
                adUnitId = context.getString(R.string.ad_unit_id)
            }
        },
        update = { view ->
            view.loadAd(AdRequest.Builder().build())
        }
    )
}
