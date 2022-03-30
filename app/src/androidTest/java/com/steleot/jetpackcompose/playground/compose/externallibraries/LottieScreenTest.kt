package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LottieScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLottieScreen() {
        composeTestRule.mainClock.autoAdvance = false
        composeTestRule.setContent {
            TestTheme {
                LottieScreen()
            }
        }
        composeTestRule.mainClock.advanceTimeBy(5_000L)
        // todo
    }
}