package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ExtendedRoundedScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testExtendedRoundedScreen() {
        composeTestRule.setContent {
            TestTheme {
                ExtendedRoundedScreen()
            }
        }
        // todo
    }
}