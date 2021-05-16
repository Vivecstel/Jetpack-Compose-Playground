package com.steleot.jetpackcompose.playground.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(@ApplicationContext context: Context) =
        FirebaseAnalytics.getInstance(context)

    @Provides
    @Singleton
    fun provideFirebaseCrashlytics() = FirebaseCrashlytics.getInstance()

    @Provides
    @Singleton
    fun provideProtoManager(@ApplicationContext context: Context) = ProtoManager(context)

    @Provides
    @Singleton
    fun provideInAppReviewHelper(
        @ApplicationContext context: Context,
        protoManager: ProtoManager
    ) = InAppReviewHelper(context, protoManager)
}