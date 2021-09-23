package com.steleot.jetpackcompose.playground.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class GithubHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain
        .request()
        .newBuilder()
        .header(ACCEPT, ACCEPT_VALUE)
        .build()
        .let { chain.proceed(it) }

    companion object {

        private const val ACCEPT = "Accept"

        private const val ACCEPT_VALUE = "application/vnd.github.v3+json"
    }
}