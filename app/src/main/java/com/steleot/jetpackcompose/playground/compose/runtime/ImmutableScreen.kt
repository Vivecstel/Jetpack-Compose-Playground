package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/ImmutableScreen.kt"

@Composable
fun ImmutableScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Immutable,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
        Text(stringResource(id = R.string.name_args, person.name))
        Text(stringResource(id = R.string.phone_args, person.phoneNumber))
    }
}

@Immutable
data class Person(val name: String, val phoneNumber: String = "")
