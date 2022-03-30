package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BottomDrawerScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBottomDrawerScreen() {
        composeTestRule.setContent {
            TestTheme {
                BottomDrawerScreen()
            }
        }
        // todo
    }
}