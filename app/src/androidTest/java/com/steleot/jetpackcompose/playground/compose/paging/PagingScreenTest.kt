package com.steleot.jetpackcompose.playground.compose.paging

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class PagingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPagingScreen() {
        composeTestRule.setContent {
            TestTheme {
                PagingScreen()
            }
        }
        // todo
    }
}