package com.steleot.jetpackcompose.playground.api

import com.steleot.jetpackcompose.playground.api.data.Release
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("repos/{owner}/{repo}/releases")
    suspend fun getReleases(
        @Path("owner") user: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 10
    ): List<Release>
}
