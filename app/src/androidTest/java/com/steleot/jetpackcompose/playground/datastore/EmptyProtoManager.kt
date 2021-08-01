package com.steleot.jetpackcompose.playground.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EmptyProtoManager: ProtoManager {

    override val isAnalyticsEnabled: Flow<Boolean> = flowOf(false)

    override val isCrashlyticsEnabled: Flow<Boolean> = flowOf(false)

    override val reviewTimeStamp: Flow<Long> = flowOf(0)

    override suspend fun setIsAnalyticsEnabled(isEnabled: Boolean) {

    }

    override suspend fun setIsCrashlyticsEnabled(isEnabled: Boolean) {

    }

    override suspend fun setReviewTimeStamp(timeStamp: Long) {

    }
}