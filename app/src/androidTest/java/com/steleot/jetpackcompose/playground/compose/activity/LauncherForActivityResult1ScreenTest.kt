package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LauncherForActivityResult1ScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLauncherForActivityResult1Screen() {
        composeTestRule.setContent {
            TestTheme {
                LauncherForActivityResult1Screen()
            }
        }
        // todo
    }
}