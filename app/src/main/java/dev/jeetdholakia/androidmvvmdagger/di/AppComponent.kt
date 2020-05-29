package dev.jeetdholakia.androidmvvmdagger.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.jeetdholakia.androidmvvmdagger.BaseApplication
import dev.jeetdholakia.androidmvvmdagger.SessionManager
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthModule
import dev.jeetdholakia.androidmvvmdagger.di.auth.AuthViewModelsModule
import dev.jeetdholakia.androidmvvmdagger.di.main.MainModule
import dev.jeetdholakia.androidmvvmdagger.di.main.MainViewModelsModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        AuthViewModelsModule::class,
        AuthModule::class,
    MainViewModelsModule::class,
    MainModule::class
    ]
)
public interface AppComponent : AndroidInjector<BaseApplication> {

    var sessionManager: SessionManager
        get() = SessionManager()
        set(value) = TODO()

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}