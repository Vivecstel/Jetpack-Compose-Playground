package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ChainScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

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