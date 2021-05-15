package com.steleot.jetpackcompose.playground.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAnalytics(@ApplicationContext context: Context) =
        FirebaseAnalytics.getInstance(context)

    @Provides
    fun provideFirebaseCrashlytics() = FirebaseCrashlytics.getInstance()
}