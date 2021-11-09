package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LauncherForActivityResult1ScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

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