package com.steleot.jetpackcompose.playground.utils

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import timber.log.Timber

fun NavController.navigateSafe(
    route: String,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    try {
        navigate(
            route = route,
            navOptions = navOptions,
            navigatorExtras = navigatorExtras,
        )
    } catch (e: Exception) {
        Timber.e(e)
    }
}