package dev.jeetdholakia.androidmvvmdagger.di

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    companion object {
        @Provides
        fun someString(): String {
            return "Ola amigo"
        }
    }
}