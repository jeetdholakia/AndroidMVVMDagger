package dev.jeetdholakia.androidmvvmdagger.network.main

import dev.jeetdholakia.androidmvvmdagger.models.Post
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    fun getPostsFromUser(@Query("userId") id: Int): Flowable<List<Post>>
}