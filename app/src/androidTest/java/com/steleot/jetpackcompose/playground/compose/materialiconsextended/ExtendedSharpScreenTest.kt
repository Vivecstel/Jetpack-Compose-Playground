package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ExtendedSharpScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testExtendedSharpScreen() {
        composeTestRule.setContent {
            TestTheme {
                ExtendedSharpScreen()
            }
        }
        // todo
    }
}