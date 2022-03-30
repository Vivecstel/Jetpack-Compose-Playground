package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class HtmlTextScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testHtmlTextScreen() {
        composeTestRule.setContent {
            TestTheme {
                HtmlTextScreen()
            }
        }
        // todo
    }
}