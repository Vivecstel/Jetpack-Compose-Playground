package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "runtime/ImmutableScreen.kt"

@Composable
fun ImmutableScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Immutable,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PeopleView(
                listOf(
                    Person("Jetpack", "1234"),
                    Person("Compose", "4567"),
                    Person("Playground", "8901"),
                )
            )
        }
    }
}

@Composable
private fun PeopleView(people: List<Person>) {
    Column {
        for (person in people) {
            PersonView(person)
        }
    }
}

@Composable
private fun PersonView(person: Person) {
    Column {
        Row {
            Text("Name: ")
            Text(person.name)
        }
        Row {
            Text("Phone: ")
            Text(person.phoneNumber)
        }
    }
}

@Immutable
data class Person(val name: String, val phoneNumber: String = "")
