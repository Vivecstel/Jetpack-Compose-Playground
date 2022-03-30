package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class SwitchScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSwitchScreen() {
        composeTestRule.setContent {
            TestTheme {
                SwitchScreen()
            }
        }
        // todo
    }
}