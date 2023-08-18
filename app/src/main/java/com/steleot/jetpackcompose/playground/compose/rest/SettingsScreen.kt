package com.steleot.jetpackcompose.playground.compose.rest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.messaging.FirebaseMessaging
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.DarkThemeMode
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.material.getMaterialColors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.utils.handleEnableSubscription
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
            SettingsListItem(stringResource(id = R.string.firebase_analytics), analyticsEnabled) {
                viewModel.onAnalyticsChanged(it)
            }
            Divider()
            SettingsListItem(stringResource(id = R.string.firebase_messaging), messagingEnabled) {
                viewModel.onMessagingChanged(it)
            }
            Divider()
            SettingsListItem(
                stringResource(id = R.string.firebase_crashlytics),
                crashlyticsEnabled
            ) {
                viewModel.onCrashlyticsChanged(it)
            }
            Divider()
            ChangeColorPaletteItem(ColorPalette.values(), theme, setTheme) {
                viewModel.onColorPaletteChanged(it)
            }
            Divider()
            ChangeDarkThemeModeItem(DarkThemeMode.values(), theme, setTheme) {
                viewModel.onDarkThemeModeChanged(it)
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
private fun ChangeColorPaletteItem(
    palettes: Array<ColorPalette>,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    onColorPaletteChanged: (ColorPalette) -> Unit
) {
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
    SettingsScrollableRow(
        text = stringResource(id = R.string.change_application_theme_color),
        state = state,
    ) {
        itemsIndexed(palettes) { index, colorPalette ->
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

@Composable
private fun SettingsScrollableRow(
    text: String,
    state: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {
    Column {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        LazyRow(
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            content()
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
    SettingCircleShapeBox(
        colorPalette = colorPalette,
        darkThemeMode = theme.darkThemeMode,
        isSystemInDarkTheme = theme.isSystemInDarkTheme,
        isLast = isLast,
        isSelected = isSelected,
        text = stringResource(
            id = when (colorPalette) {
                ColorPalette.RED -> R.string.red
                ColorPalette.PINK -> R.string.pink
                ColorPalette.PURPLE -> R.string.purple
                ColorPalette.DEEP_PURPLE -> R.string.deep_purple
                ColorPalette.INDIGO -> R.string.indigo
                ColorPalette.BLUE -> R.string.blue
                ColorPalette.LIGHT_BLUE -> R.string.light_blue
                ColorPalette.CYAN -> R.string.cyan
                ColorPalette.TEAL -> R.string.teal
                ColorPalette.GREEN -> R.string.green
                ColorPalette.LIGHT_GREEN -> R.string.light_green
                ColorPalette.LIME -> R.string.lime
                ColorPalette.YELLOW -> R.string.yellow
                ColorPalette.AMBER -> R.string.amber
                ColorPalette.ORANGE -> R.string.orange
                ColorPalette.DEEP_ORANGE -> R.string.deep_orange
                ColorPalette.BROWN -> R.string.brown
                ColorPalette.GREY -> R.string.grey
                ColorPalette.BLUE_GREY -> R.string.blue_grey
            }
        ),
        onClick = {
            onColorPaletteChanged(colorPalette)
            setTheme(theme.copy(colorPalette = colorPalette))
        }
    ) {
        if (isSelected) {
            Icon(
                Icons.Filled.Check,
                contentDescription = stringResource(id = R.string.color_palette_selected),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun SettingCircleShapeBox(
    colorPalette: ColorPalette,
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
    isLast: Boolean,
    isSelected: Boolean,
    text: String,
    onClick: () -> Unit,
    icon: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = if (isLast) 16.dp else 0.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    colorPalette.getMaterialColors(
                        darkThemeMode,
                        isSystemInDarkTheme
                    ).primary
                )
                .then(
                    if (isSelected) {
                        Modifier.border(
                            BorderStroke(2.dp, MaterialTheme.colors.onSurface),
                            shape = CircleShape
                        )
                    } else Modifier
                )
        ) {
            icon()
        }
        Text(
            text = text,
            style = MaterialTheme.typography.caption.copy(
                fontSize = 9.sp
            ),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp)
        )
    }
}

@Composable
private fun ChangeDarkThemeModeItem(
    modes: Array<DarkThemeMode>,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    onDarkThemeModeChanged: (DarkThemeMode) -> Unit
) {
    SettingsScrollableRow(
        stringResource(id = R.string.change_application_theme_mode),
    ) {
        itemsIndexed(modes) { index, darkThemeMode ->
            DarkThemeModeBox(
                darkThemeMode,
                index == modes.size - 1,
                theme,
                setTheme,
                onDarkThemeModeChanged
            )
        }
    }
}

@Composable
private fun DarkThemeModeBox(
    darkThemeMode: DarkThemeMode,
    isLast: Boolean,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    onDarkThemeModeChanged: (DarkThemeMode) -> Unit
) {
    val isSelected = darkThemeMode == theme.darkThemeMode
    SettingCircleShapeBox(
        colorPalette = theme.colorPalette,
        darkThemeMode = theme.darkThemeMode,
        isSystemInDarkTheme = theme.isSystemInDarkTheme,
        isLast = isLast,
        isSelected = isSelected,
        text = stringResource(
            id = when (darkThemeMode) {
                DarkThemeMode.SYSTEM -> R.string.system
                DarkThemeMode.DARK -> R.string.dark
                DarkThemeMode.LIGHT -> R.string.light
            }
        ),
        onClick = {
            onDarkThemeModeChanged(darkThemeMode)
            setTheme(theme.copy(darkThemeMode = darkThemeMode))
        }
    ) {
        Icon(
            imageVector = when (darkThemeMode) {
                DarkThemeMode.SYSTEM -> Icons.Default.Android
                DarkThemeMode.DARK -> Icons.Default.ModeNight
                DarkThemeMode.LIGHT -> Icons.Default.WbSunny
            },
            contentDescription = stringResource(id = R.string.theme_mode_selected),
            modifier = Modifier.align(Alignment.Center)
        )
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
        firebaseMessaging.handleEnableSubscription(isEnabled)
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

    fun onDarkThemeModeChanged(darkThemeMode: DarkThemeMode) {
        viewModelScope.launch {
            protoManager.setDarkThemeMode(darkThemeMode)
        }
    }
}