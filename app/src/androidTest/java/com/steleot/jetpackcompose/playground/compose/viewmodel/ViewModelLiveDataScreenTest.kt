package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ViewModelLiveDataScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testViewModelLiveDataScreen() {
        composeTestRule.setContent {
            TestTheme {
//                ViewModelLiveDataScreen()
            }
        }
        // todo
    }
}