package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class OrchestraBalloonScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOrchestraBalloonScreen() {
        composeTestRule.setContent {
            TestTheme {
                OrchestraBalloonScreen()
            }
        }
        // todo
    }
}