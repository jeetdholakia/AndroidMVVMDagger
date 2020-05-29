package dev.jeetdholakia.androidmvvmdagger.di.auth

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.jeetdholakia.androidmvvmdagger.di.ViewModelKey
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthViewModel

@Module
abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}