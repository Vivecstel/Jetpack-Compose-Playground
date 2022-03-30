package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ComposeParticleSystemScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testComposeParticleSystemScreen() {
        composeTestRule.mainClock.autoAdvance = false
        composeTestRule.setContent {
            TestTheme {
                ComposeParticleSystemScreen()
            }
        }
        composeTestRule.mainClock.advanceTimeBy(5_000L)
        // todo
    }
}