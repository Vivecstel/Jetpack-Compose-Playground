package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.insets.systemBarsPadding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    val analyticsEnabled: Boolean by viewModel.analyticsEnabled.collectAsState()
    val crashlyticsEnabled: Boolean by viewModel.crashlyticsEnabled.collectAsState()

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
            SettingsListItem("Firebase crashlytics collection", crashlyticsEnabled) {
                viewModel.onCrashlyticsChanged(it)
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