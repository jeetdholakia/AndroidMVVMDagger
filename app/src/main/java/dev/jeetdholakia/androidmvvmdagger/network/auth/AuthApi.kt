package dev.jeetdholakia.androidmvvmdagger.network.auth

import dev.jeetdholakia.androidmvvmdagger.models.User
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("/users/{id}")
    fun getUser(@Path("id") id: Int) : Flowable<User>
}