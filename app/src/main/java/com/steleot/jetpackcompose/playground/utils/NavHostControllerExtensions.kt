package com.steleot.jetpackcompose.playground.utils

import androidx.navigation.NavHostController
import timber.log.Timber

inline fun <reified T>NavHostController.setResult(key: String, value: T) {
    this.previousBackStackEntry?.savedStateHandle?.set(key, value) ?: run {
        Timber.d("Can\'t find previous back stack entry.")
    }
}