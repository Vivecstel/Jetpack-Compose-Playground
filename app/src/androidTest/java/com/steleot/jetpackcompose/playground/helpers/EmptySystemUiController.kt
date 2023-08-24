package com.steleot.jetpackcompose.playground.helpers

import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController

class EmptySystemUiController : SystemUiController {

    override var isNavigationBarContrastEnforced: Boolean = false
    override var isNavigationBarVisible: Boolean = false
    override var isStatusBarVisible: Boolean = false
    override var navigationBarDarkContentEnabled: Boolean = false
    override var statusBarDarkContentEnabled: Boolean = false
    override var systemBarsBehavior: Int = 0

    override fun setNavigationBarColor(
        color: Color,
        darkIcons: Boolean,
        navigationBarContrastEnforced: Boolean,
        transformColorForLightContent: (Color) -> Color
    ) {
        /* empty implementation */
    }

    override fun setStatusBarColor(
        color: Color,
        darkIcons: Boolean,
        transformColorForLightContent: (Color) -> Color
    ) {
        /* empty implementation */
    }
}