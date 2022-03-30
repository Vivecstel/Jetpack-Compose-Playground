package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class RememberCoroutineScopeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRememberCoroutineScopeScreen() {
        composeTestRule.setContent {
            TestTheme {
                RememberCoroutineScopeScreen()
            }
        }
        // todo
    }
}