package com.steleot.jetpackcompose.playground.helpers

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.IntentSender.SendIntentException
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.utils.await
import timber.log.Timber

interface InAppUpdateHelper {

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}

@Suppress("unused")
class InAppUpdateHelperImpl(
    private val activity: ComponentActivity,
    private val appUpdateManager: AppUpdateManager
) : InAppUpdateHelper, DefaultLifecycleObserver {

    private lateinit var alertDialog: AlertDialog
    private val listener = InstallStateUpdatedListener { state ->
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            showFlexibleAlertDialog()
        }
    }

    init {
        setUpFlexibleAlertDialog()
        activity.lifecycle.addObserver(this)
        activity.lifecycleScope.launchWhenCreated {
            try {
                val appUpdateInfo = appUpdateManager.appUpdateInfo.await()
                if (UpdateAvailability.UPDATE_AVAILABLE == appUpdateInfo.updateAvailability()) {
                    Timber.d("Update available")
                    val shouldForceImmediateUpdate =
                        appUpdateInfo.updatePriority() >= 4
                                || appUpdateInfo.clientVersionStalenessDays() ?: -1 >= DAYS_FOR_IMMEDIATE_UPDATE
                    if (shouldForceImmediateUpdate
                        && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
                    ) {
                        startUpdate(appUpdateInfo, AppUpdateType.IMMEDIATE)
                    } else if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                        appUpdateManager.registerListener(listener)
                        startUpdate(appUpdateInfo, AppUpdateType.FLEXIBLE)
                    }
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    private fun setUpFlexibleAlertDialog() {
        alertDialog = AlertDialog.Builder(activity)
            .setTitle(R.string.in_app_update_message)
            .setCancelable(false)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                appUpdateManager.completeUpdate()
            }
            .create()
    }

    private fun showFlexibleAlertDialog() {
        if (::alertDialog.isInitialized && !alertDialog.isShowing) {
            alertDialog.show()
        }
    }

    private fun startUpdate(
        appUpdateInfo: AppUpdateInfo,
        @AppUpdateType appUpdateType: Int,
    ) {
        try {
            appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                activity,
                AppUpdateOptions.newBuilder(appUpdateType)
                    .setAllowAssetPackDeletion(true)
                    .build(),
                REQUEST_CODE
            )
        } catch (e: SendIntentException) {
            Timber.e(
                e,
                "Failed to start in app update of type: " +
                        if (AppUpdateType.IMMEDIATE == appUpdateType) "immediate" else "flexible"
            )
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        activity.lifecycleScope.launchWhenResumed {
            try {
                val appUpdateInfo = appUpdateManager.appUpdateInfo.await()
                if (InstallStatus.DOWNLOADED == appUpdateInfo.installStatus()) {
                    showFlexibleAlertDialog()
                } else if (UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS == appUpdateInfo.updateAvailability()) {
                    startUpdate(appUpdateInfo, AppUpdateType.IMMEDIATE)
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        appUpdateManager.unregisterListener(listener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode != RESULT_OK) {
            Timber.d("Failed to finish the update with result code: $resultCode")
        }
    }

    companion object {
        private const val DAYS_FOR_IMMEDIATE_UPDATE = 14
        private const val REQUEST_CODE = 999
    }
}