package com.steleot.jetpackcompose.playground.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.CallSuper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import timber.log.Timber

class GoogleSignContract(
    private val client: GoogleSignInClient
) : ActivityResultContract<Void?, String?>() {

    @CallSuper
    override fun createIntent(context: Context, input: Void?): Intent {
        return client.signInIntent
    }

    override fun getSynchronousResult(
        context: Context,
        input: Void?
    ): SynchronousResult<String?>? = null

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        intent.takeIf { resultCode == Activity.RESULT_OK }?.apply {
            val task = GoogleSignIn.getSignedInAccountFromIntent(this)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Timber.d("Firebase auth with google: ${account.id}")
                return account.idToken
            } catch (e: ApiException) {
                Timber.e(e, "Google sign in failed")
            }
        }

        return null
    }
}