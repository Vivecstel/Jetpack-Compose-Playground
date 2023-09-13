package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/MultiChoiceSegmentedButtonRowScreen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiChoiceSegmentedButtonRowScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.MultiChoiceSegmentedButtonRow,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val checkedList = remember { mutableStateListOf<Int>() }
            val options = listOf(R.string.jetpack, R.string.compose, R.string.playground)
            MultiChoiceSegmentedButtonRow {
                options.forEachIndexed { index, resource ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),
                        onCheckedChange = {
                            if (index in checkedList) {
                                checkedList.remove(index)
                            } else {
                                checkedList.add(index)
                            }
                        },
                        checked = index in checkedList
                    ) {
                        Text(text = stringResource(id = resource))
                    }
                }
            }
        }
    }
}