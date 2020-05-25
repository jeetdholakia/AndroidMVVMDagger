package dev.jeetdholakia.androidmvvmdagger.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dev.jeetdholakia.androidmvvmdagger.presentation.AuthActivity

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

}