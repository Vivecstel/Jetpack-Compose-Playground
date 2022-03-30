package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class RoundedScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRoundedScreen() {
        composeTestRule.setContent {
            TestTheme {
                RoundedScreen()
            }
        }
        // todo
    }
}