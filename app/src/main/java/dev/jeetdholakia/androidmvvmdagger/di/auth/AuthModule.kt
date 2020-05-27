package dev.jeetdholakia.androidmvvmdagger.di.auth

import dagger.Module
import dagger.Provides
import dev.jeetdholakia.androidmvvmdagger.network.auth.AuthApi
import retrofit2.Retrofit

@Module
class AuthModule {

    companion object {
        @Provides
        fun provideAuthApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)

        }
    }

}