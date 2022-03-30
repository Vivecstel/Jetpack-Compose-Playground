package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LocalContentAlphaScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLocalContentAlphaScreen() {
        composeTestRule.setContent {
            TestTheme {
                LocalContentAlphaScreen()
            }
        }
        // todo
    }
}