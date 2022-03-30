package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class RememberSaveableScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRememberSaveableScreen() {
        composeTestRule.setContent {
            TestTheme {
                RememberSaveableScreen()
            }
        }
        // todo
    }
}