package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LauncherForActivityResult2ScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLauncherForActivityResult2Screen() {
        composeTestRule.setContent {
            TestTheme {
                LauncherForActivityResult2Screen()
            }
        }
        // todo
    }
}