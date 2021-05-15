package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.google.accompanist.insets.systemBarsPadding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar

private val routes = listOf(
    MainNavRoutes.Activity,
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.CustomExamples,
    MainNavRoutes.ExternalLibraries,
    MainNavRoutes.Foundation,
    MainNavRoutes.FoundationLayout,
    MainNavRoutes.Material,
    MainNavRoutes.MaterialIcons,
    MainNavRoutes.MaterialIConsExtended,
    MainNavRoutes.Navigation,
    MainNavRoutes.Paging,
    MainNavRoutes.Runtime,
    MainNavRoutes.Ui,
    MainNavRoutes.ViewModel,
)

@Composable
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    showBackArrow: Boolean = false,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showSettings: Boolean = false,
    showAd: Boolean = true,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = showBackArrow,
                navigateToSearch = navigateToSearch
            )
        },
        floatingActionButton = {
            if (showSettings) {
                FloatingActionButton(onClick = {
                    navController.navigate(MainNavRoutes.Settings)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Icon Floating Action Button"
                    )
                }
            }
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
            val context = view.context
            if (context is MainActivity) {
                context.lifecycle.addObserver(object :
                    DefaultLifecycleObserver {
                    override fun onPause(owner: LifecycleOwner) {
                        view.pause()
                    }

                    override fun onResume(owner: LifecycleOwner) {
                        view.resume()
                    }

                    override fun onDestroy(owner: LifecycleOwner) {
                        view.destroy()
                    }
                })
            }
        }
    )
}
