package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ProduceStateScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testProduceStateScreen() {
        composeTestRule.setContent {
            TestTheme {
                ProduceStateScreen()
            }
        }
        // todo
    }
}