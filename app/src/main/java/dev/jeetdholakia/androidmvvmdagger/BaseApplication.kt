package dev.jeetdholakia.androidmvvmdagger

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dev.jeetdholakia.androidmvvmdagger.di.AppComponent
import dev.jeetdholakia.androidmvvmdagger.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

}