package dev.jeetdholakia.androidmvvmdagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthViewModel
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelProviderFactory

@Suppress("unused")
@Module
abstract class ViewModelFactoryModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(AuthViewModel::class)
//    abstract fun bindThemeViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}
