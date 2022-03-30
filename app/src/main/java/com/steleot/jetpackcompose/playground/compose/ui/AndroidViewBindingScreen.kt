package com.steleot.jetpackcompose.playground.compose.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.databinding.AndroidViewBindingExampleBinding
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/AndroidViewBindingScreen.kt"

@Composable
fun AndroidViewBindingScreen() {
    DefaultScaffold(
        title = UiNavRoutes.AndroidViewBinding,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AndroidViewExample()
            AndroidViewBindingExample()
        }
    }
}

@Composable
private fun AndroidViewExample() {
    AndroidView({ context ->
        TextView(context).apply {
            text = context.getString(R.string.android_textview)
        }
    })
    var size by remember { mutableStateOf(20) }
    AndroidView(::View,
        Modifier
            .clickable { size += 20 }
            .background(Color.Blue)) { view ->
        view.layoutParams = ViewGroup.LayoutParams(size, size)
    }
}

@Composable
private fun AndroidViewBindingExample() {
    AndroidView({ context ->
        AndroidViewBindingExampleBinding.inflate(LayoutInflater.from(context)).apply {
            second.setBackgroundColor(Color.Gray.toArgb())
        }.root
    })
}