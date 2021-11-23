package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class OutlinedTextFieldScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testOutlinedTextFieldScreen() {
        composeTestRule.setContent {
            TestTheme {
                OutlinedTextFieldScreen()
            }
        }
        // todo
    }
}