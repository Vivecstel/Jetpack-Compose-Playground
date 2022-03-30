package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ComposeTimelineViewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testComposeTimelineViewScreen() {
        composeTestRule.setContent {
            TestTheme {
//                ComposeTimelineViewScreen()
            }
        }
        // todo
    }
}