package com.steleot.jetpackcompose.playground.helpers

class EmptyFavoriteHelperImpl : FavoriteHelper {

    override suspend fun isFavorite(userId: String, route: String): Boolean = false

    override suspend fun getFavoriteSet(
        userId: String,
        shouldThrowException: Boolean
    ): Set<String> = emptySet()

    override suspend fun addRemoveFavorite(userId: String, route: String): Boolean = false

    override fun clearAll() {
        /* empty implementation */
    }
}