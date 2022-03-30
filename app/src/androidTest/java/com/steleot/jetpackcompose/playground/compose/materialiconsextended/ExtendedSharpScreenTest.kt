package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ExtendedSharpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

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