package dev.jeetdholakia.androidmvvmdagger

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dev.jeetdholakia.androidmvvmdagger.di.AppComponent
import dev.jeetdholakia.androidmvvmdagger.di.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


class BaseApplication : DaggerApplication() {

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}