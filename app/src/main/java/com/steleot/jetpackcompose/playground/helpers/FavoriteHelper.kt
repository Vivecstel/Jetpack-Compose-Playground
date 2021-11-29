package com.steleot.jetpackcompose.playground.helpers

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import timber.log.Timber

interface FavoriteHelper {

    suspend fun isFavorite(
        userId: String,
        route: String
    ): Boolean

    suspend fun getFavoriteSet(
        userId: String,
        shouldThrowException: Boolean = false
    ): Set<String>

    suspend fun addRemoveFavorite(
        userId: String,
        route: String,
    ): Boolean

    fun clearAll()
}

class FavoriteHelperImpl(
    private val firebaseFirestore: FirebaseFirestore,
    private val firebaseAnalytics: FirebaseAnalytics,
) : FavoriteHelper {

    private val cachedFavorites = mutableSetOf<String>()
    private var hasCommunicatedWithServer = false

    override suspend fun isFavorite(
        userId: String,
        route: String
    ): Boolean {
        val set = getFavoriteSet(userId)
        return set.contains(route)
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun getFavoriteSet(
        userId: String,
        shouldThrowException: Boolean
    ): Set<String> {
        if (hasCommunicatedWithServer) {
            cachedFavorites.toSet()
        } else {
            try {
                val snapshot =
                    firebaseFirestore.collection(Favorites).document(userId).get().await()
                val favorites = snapshot.data?.get(Favorites) as? MutableList<String>
                cachedFavorites.addAll(favorites ?: emptySet())
                hasCommunicatedWithServer = true
            } catch (e: Exception) {
                Timber.e(e)
                if (shouldThrowException) throw e
            }
        }
        return cachedFavorites
    }

    override suspend fun addRemoveFavorite(
        userId: String,
        route: String
    ): Boolean {
        var returnValue = if (cachedFavorites.contains(route)) {
            cachedFavorites.remove(route)
            false
        } else {
            cachedFavorites.add(route)
            true
        }
        try {
            firebaseFirestore.collection(Favorites).document(userId)
                .set(mapOf(Favorites to cachedFavorites.toList())).await()
            firebaseAnalytics.logEvent("favorite", Bundle().apply {
                putString("route", route)
                putString("action", if (returnValue) "added" else "removed")
            })
        } catch (e: Exception) {
            Timber.e(e)
            returnValue = !returnValue
        }

        return returnValue
    }

    override fun clearAll() {
        cachedFavorites.clear()
        hasCommunicatedWithServer = false
    }

    companion object {
        private const val Favorites = "favorites"
    }
}