package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class SnackBarScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSnackBarScreen() {
        composeTestRule.setContent {
            TestTheme {
                SnackBarScreen()
            }
        }
        // todo
    }
}
