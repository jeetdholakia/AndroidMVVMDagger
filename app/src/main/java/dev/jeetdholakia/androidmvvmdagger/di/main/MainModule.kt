package dev.jeetdholakia.androidmvvmdagger.di.main

import dagger.Module
import dagger.Provides
import dev.jeetdholakia.androidmvvmdagger.network.main.MainApi
import dev.jeetdholakia.androidmvvmdagger.ui.main.posts.PostsRecyclerAdapter
import retrofit2.Retrofit

@Module
class MainModule {
    companion object {

        @Provides
        fun provideAdapter(): PostsRecyclerAdapter {
            return  PostsRecyclerAdapter()
        }

        @Provides
        fun provideMainApi(retrofit: Retrofit): MainApi {
            return retrofit.create(MainApi::class.java)
        }
    }
}