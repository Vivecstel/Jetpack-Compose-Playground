package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "runtime/KeyScreen.kt"

@Composable
fun KeyScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Key.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LocallyUniqueKeysExample()
            Divider()
            NotAlwaysUniqueKeysExample()
            Divider()
            MoreCorrectUniqueKeysExample()
            Divider()
        }
    }
}

private val users = listOf(
    User(1, "Jetpack"),
    User(1, "Compose"),
    User(2, "Playground"),
    User(3, "Playground"),
    User(4, "Jetpack"),
)

@Composable
private fun LocallyUniqueKeysExample() {
    for (user in users) {
        key(user.id) { UserPreview(user = user) }
    }
}

@Composable
private fun UserPreview(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Id: ${user.id}", modifier = Modifier.weight(1f))
        Text(text = "Name: ${user.name}", modifier = Modifier.weight(1f))
    }
}

private val relationships = mapOf(
    User(1, "Jetpack") to User(2, "Playground"),
    User(2, "Jetpack") to User(2, "Playground 2"),
    User(1, "Jetpack2") to User(2, "Playground 3"),
    User(3, "Jetpack3") to User(2, "Playground 4"),
)

@Composable
private fun NotAlwaysUniqueKeysExample() {
    for ((child, parent) in relationships) {
        key(parent.id) {
            UserPreview(child)
            UserPreview(parent)
        }
    }
}

@Composable
fun MoreCorrectUniqueKeysExample() {
    for ((child, parent) in relationships) {
        key(parent.id to child.id) {
            UserPreview(child)
            UserPreview(parent)
        }
    }
}