package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BottomSheetScaffoldScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testBottomSheetScaffoldScreen() {
        composeTestRule.setContent {
            TestTheme {
                BottomSheetScaffoldScreen()
            }
        }
        // todo
    }
}