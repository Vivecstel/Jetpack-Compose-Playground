package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LazyVerticalStaggeredGridScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLazyVerticalStaggeredGridScreen() {
        composeTestRule.setContent {
            TestTheme {
                LazyVerticalStaggeredGridScreen()
            }
        }
        // todo
    }
}