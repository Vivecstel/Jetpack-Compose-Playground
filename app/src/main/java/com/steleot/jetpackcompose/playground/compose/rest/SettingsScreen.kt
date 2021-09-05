package com.steleot.jetpackcompose.playground.compose.rest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.messaging.FirebaseMessaging
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.getMaterialColors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit
) {
    val analyticsEnabled: Boolean by viewModel.analyticsEnabled.collectAsState()
    val messagingEnabled: Boolean by viewModel.messagingEnabled.collectAsState()
    val crashlyticsEnabled: Boolean by viewModel.crashlyticsEnabled.collectAsState()

    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.Settings,
            )
        }
    ) {
        Column {
            SettingsListItem("Firebase analytics collection", analyticsEnabled) {
                viewModel.onAnalyticsChanged(it)
            }
            Divider()
            SettingsListItem("Firebase messaging", messagingEnabled) {
                viewModel.onMessagingChanged(it)
            }
            Divider()
            SettingsListItem("Firebase crashlytics collection", crashlyticsEnabled) {
                viewModel.onCrashlyticsChanged(it)
            }
            Divider()
            ChangeThemePaletteItem(ColorPalette.values(), theme, setTheme) {
                viewModel.onColorPaletteChanged(it)
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
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun ChangeThemePaletteItem(
    palettes: Array<ColorPalette>,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    onColorPaletteChanged: (ColorPalette) -> Unit
) {
    Column {
        Text(
            text = "Change Application Theme Color",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        val state = rememberLazyListState()
        var isFirstTime by rememberSaveable { mutableStateOf(false) }
        LaunchedEffect(Unit) {
            if (!isFirstTime) {
                isFirstTime = true
                val index = palettes.indexOfFirst { it == theme.colorPalette }
                if (index > -1) {
                    state.scrollToItem(index)
                }
            }
        }
        LazyRow(
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            itemsIndexed(ColorPalette.values()) { index, colorPalette ->
                ColorPaletteBox(
                    colorPalette,
                    index == palettes.size - 1,
                    theme,
                    setTheme,
                    onColorPaletteChanged
                )
            }
        }

    }
}

@Composable
private fun ColorPaletteBox(
    colorPalette: ColorPalette,
    isLast: Boolean,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    onColorPaletteChanged: (ColorPalette) -> Unit
) {
    val isSelected = colorPalette == theme.colorPalette
    Box(
        Modifier
            .padding(start = 16.dp)
            .then(
                if (isLast) {
                    Modifier.padding(end = 16.dp)
                } else Modifier
            )
            .size(48.dp)
            .clip(CircleShape)
            .background(colorPalette.getMaterialColors(theme.isDarkTheme).primary)
            .clickable {
                onColorPaletteChanged(colorPalette)
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

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics,
    private val firebaseMessaging: FirebaseMessaging,
    private val firebaseCrashlytics: FirebaseCrashlytics,
    private val protoManager: ProtoManager,
) : ViewModel() {

    private val _analyticsEnabled = MutableStateFlow(false)
    val analyticsEnabled: StateFlow<Boolean> = _analyticsEnabled

    private val _messagingEnabled = MutableStateFlow(false)
    val messagingEnabled: StateFlow<Boolean> = _messagingEnabled

    private val _crashlyticsEnabled = MutableStateFlow(false)
    val crashlyticsEnabled: StateFlow<Boolean> = _crashlyticsEnabled

    init {
        viewModelScope.launch {
            protoManager.isAnalyticsEnabled.collect { isEnabled ->
                _analyticsEnabled.value = isEnabled
            }
        }
        viewModelScope.launch {
            protoManager.isMessagingEnabled.collect { isEnabled ->
                _messagingEnabled.value = isEnabled
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

    fun onMessagingChanged(isEnabled: Boolean) {
        _messagingEnabled.value = isEnabled
        viewModelScope.launch {
            protoManager.setIsMessagingEnabled(isEnabled)
        }
        firebaseMessaging.isAutoInitEnabled = isEnabled
    }

    fun onCrashlyticsChanged(isEnabled: Boolean) {
        _crashlyticsEnabled.value = isEnabled
        viewModelScope.launch {
            protoManager.setIsCrashlyticsEnabled(isEnabled)
        }
        firebaseCrashlytics.setCrashlyticsCollectionEnabled(isEnabled)
    }

    fun onColorPaletteChanged(colorPalette: ColorPalette) {
        viewModelScope.launch {
            protoManager.setColorPalette(colorPalette)
        }
    }
}