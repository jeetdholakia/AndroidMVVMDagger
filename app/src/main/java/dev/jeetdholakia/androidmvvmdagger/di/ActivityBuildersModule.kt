package dev.jeetdholakia.androidmvvmdagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthModule
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthViewModelsModule
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthActivity

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class,
            AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

}