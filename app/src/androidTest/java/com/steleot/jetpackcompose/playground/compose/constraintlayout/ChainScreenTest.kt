package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ChainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testChainScreen() {
        composeTestRule.setContent {
            TestTheme {
                ChainScreen()
            }
        }
        // todo
    }
}