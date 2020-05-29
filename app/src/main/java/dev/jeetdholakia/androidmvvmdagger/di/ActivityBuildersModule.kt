package dev.jeetdholakia.androidmvvmdagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthModule
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthViewModelsModule
import dev.jeetdholakia.androidmvvmdagger.di.main.MainFragmentBuildersModule
import dev.jeetdholakia.androidmvvmdagger.di.main.MainModule
import dev.jeetdholakia.androidmvvmdagger.di.main.MainViewModelsModule
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthActivity
import dev.jeetdholakia.androidmvvmdagger.ui.main.MainActivity

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class,
            AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [MainFragmentBuildersModule::class,
        MainViewModelsModule::class, MainModule::class]
    )
    abstract  fun contributeMainActivity(): MainActivity

}