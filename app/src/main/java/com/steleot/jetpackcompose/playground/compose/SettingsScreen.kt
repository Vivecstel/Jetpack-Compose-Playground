package com.steleot.jetpackcompose.playground.compose

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.insets.systemBarsPadding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.getMaterialColors
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit
) {
    val analyticsEnabled: Boolean by viewModel.analyticsEnabled.collectAsState()
    val crashlyticsEnabled: Boolean by viewModel.crashlyticsEnabled.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.Settings,
                showBackArrow = true
            )
        }
    ) {
        Column {
            SettingsListItem("Firebase analytics collection", analyticsEnabled) {
                viewModel.onAnalyticsChanged(it)
            }
            Divider()
            SettingsListItem("Firebase crashlytics collection", crashlyticsEnabled) {
                viewModel.onCrashlyticsChanged(it)
            }
            Divider()
            ChangeThemePaletteItem(theme, setTheme)
            Divider()
            Button(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    context.startActivity(Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:")
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("steleot@hotmail.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "Feedback on Jetpack Compose Playground")
                    })
                }) {
                Text(text = "Send Feedback")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SettingsListItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    ListItem(
        trailing = {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked ->
                    onCheckedChange(checked)
                })
        }
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
private fun ChangeThemePaletteItem(
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit
) {
    Column {
        Text(
            text = "Change Application Theme",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            ColorPalette.values().forEach { colorPalette ->
                val isSelected = colorPalette == theme.colorPalette
                Box(
                    Modifier
                        .padding(start = 16.dp)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(colorPalette.getMaterialColors(theme.isDarkTheme).primary)
                        .clickable {
                            setTheme(theme.copy(colorPalette = colorPalette))
                        }
                        .then(
                            if (isSelected) {
                                Modifier.border(
                                    BorderStroke(2.dp, MaterialTheme.colors.onSurface),
                                    shape = CircleShape
                                )
                            } else Modifier
                        )
                ) {
                    if (isSelected) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "Theme Selected",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics,
    private val firebaseCrashlytics: FirebaseCrashlytics,
    private val protoManager: ProtoManager,
) : ViewModel() {

    private val _analyticsEnabled = MutableStateFlow(false)
    val analyticsEnabled: StateFlow<Boolean> = _analyticsEnabled

    private val _crashlyticsEnabled = MutableStateFlow(false)
    val crashlyticsEnabled: StateFlow<Boolean> = _crashlyticsEnabled

    init {
        viewModelScope.launch {
            protoManager.isAnalyticsEnabled.collect { isEnabled ->
                _analyticsEnabled.value = isEnabled
            }
        }
        viewModelScope.launch {
            protoManager.isCrashlyticsEnabled.collect { isEnabled ->
                _crashlyticsEnabled.value = isEnabled
            }
        }
    }

    fun onAnalyticsChanged(isEnabled: Boolean) {
        _analyticsEnabled.value = isEnabled
        viewModelScope.launch {
            protoManager.setIsAnalyticsEnabled(isEnabled)
        }
        firebaseAnalytics.setAnalyticsCollectionEnabled(isEnabled)
    }

    fun onCrashlyticsChanged(isEnabled: Boolean) {
        _crashlyticsEnabled.value = isEnabled
        viewModelScope.launch {
            protoManager.setIsCrashlyticsEnabled(isEnabled)
        }
        firebaseCrashlytics.setCrashlyticsCollectionEnabled(isEnabled)
    }
}