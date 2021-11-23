package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class SideEffectScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testSideEffectScreen() {
        composeTestRule.setContent {
            TestTheme {
                SideEffectScreen()
            }
        }
        // todo
    }
}