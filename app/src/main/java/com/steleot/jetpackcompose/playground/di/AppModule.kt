package com.steleot.jetpackcompose.playground.di

import android.annotation.SuppressLint
import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.datastore.ProtoManagerImpl
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelper
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelperImpl
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelperImpl
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
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @SuppressLint("MissingPermission")
    @Provides
    @Singleton
    fun provideFirebaseAnalytics(@ApplicationContext context: Context) =
        FirebaseAnalytics.getInstance(context)

    @Provides
    @Singleton
    fun provideFirebaseMessaging() = FirebaseMessaging.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseInstallations() = FirebaseInstallations.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseCrashlytics() = FirebaseCrashlytics.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideProtoManager(@ApplicationContext context: Context): ProtoManager =
        ProtoManagerImpl(context)

    @Provides
    @Singleton
    fun provideInAppReviewHelper(
        @ApplicationContext context: Context,
        protoManager: ProtoManager
    ): InAppReviewHelper = InAppReviewHelperImpl(context, protoManager)

    @Provides
    @Singleton
    fun provideFavoriteHelper(
        firebaseFirestore: FirebaseFirestore,
        firebaseAnalytics: FirebaseAnalytics,
    ): FavoriteHelper = FavoriteHelperImpl(firebaseFirestore, firebaseAnalytics)
}