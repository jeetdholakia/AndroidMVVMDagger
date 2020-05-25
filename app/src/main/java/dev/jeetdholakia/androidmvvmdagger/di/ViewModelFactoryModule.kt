package dev.jeetdholakia.androidmvvmdagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elifox.legocatalog.legoset.ui.LegoSetViewModel
import com.elifox.legocatalog.legoset.ui.LegoSetsViewModel
import com.elifox.legocatalog.legotheme.ui.LegoThemeViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelFactory

@Suppress("unused")
@Module
abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(LegoThemeViewModel::class)
//    abstract fun bindThemeViewModel(viewModel: LegoThemeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
