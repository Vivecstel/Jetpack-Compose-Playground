package com.steleot.jetpackcompose.playground.compose.activity

import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "activity/LauncherForActivityResult2Screen.kt"

@Composable
fun LauncherForActivityResult2Screen() {
    DefaultScaffold(
        title = ActivityNavRoutes.LauncherForActivityResult2,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LauncherForActivityResultExample()
        }
    }
}

@Composable
private fun LauncherForActivityResultExample() {
    val result = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickContact()) {
        result.value = it
    }

    Button(
        onClick = {
            launcher.launch()
        }
    ) {
        Text(text = stringResource(id = R.string.choose_contact))
    }

    result.value?.let { uri ->
        val projection = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
        val cursor = LocalContext.current.contentResolver.query(
            uri, projection,
            null, null, null
        )
        cursor?.let {
            cursor.moveToFirst()
            val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val name = cursor.getString(nameIndex)
            Text(text = stringResource(id = R.string.name_args, name))
            it.close()
        } ?: run {
            Text(text = stringResource(id = R.string.contact_not_found))
        }
    }
}