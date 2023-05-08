package com.appslabke.every_shillings_android.api

import com.appslabke.every_shillings_android.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    // register user example
    @POST("/register")
    suspend fun register(@Body user: User)

    suspend fun verifyRegistration()

    suspend fun login()

    suspend fun verifyLogin()

    suspend fun resendCode()
}