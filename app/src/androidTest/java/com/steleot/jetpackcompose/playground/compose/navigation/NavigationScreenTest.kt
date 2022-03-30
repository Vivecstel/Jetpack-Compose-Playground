package com.steleot.jetpackcompose.playground.compose.navigation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class NavigationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNavigationScreen() {
        composeTestRule.setContent {
            TestTheme {
                NavigationScreen()
            }
        }
        // todo
    }
}