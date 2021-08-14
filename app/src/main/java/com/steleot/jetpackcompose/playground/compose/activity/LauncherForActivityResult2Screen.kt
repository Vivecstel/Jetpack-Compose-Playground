package com.steleot.jetpackcompose.playground.compose.activity

import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ActivityNavRoutes

private const val Url = "activity/LauncherForActivityResult2Screen.kt"

@Composable
fun LauncherForActivityResult2Screen() {
    DefaultScaffold(
        title = ActivityNavRoutes.LauncherForActivityResult2,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LauncherForActivityResultExample()
        }
    }
}

@Composable
private fun LauncherForActivityResultExample() {
    val result = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickContact()) {
        result.value = it
    }

    Button(
        onClick = {
            launcher.launch()
        }
    ) {
        Text(text = "Choose contact")
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
            Text(text = "name : $name")
            it.close()
        } ?: run {
            Text(text = "Contact not found")
        }
    }
}