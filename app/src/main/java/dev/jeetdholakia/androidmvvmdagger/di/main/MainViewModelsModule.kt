package dev.jeetdholakia.androidmvvmdagger.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.jeetdholakia.androidmvvmdagger.di.ViewModelKey
import dev.jeetdholakia.androidmvvmdagger.ui.main.posts.PostsViewModel
import dev.jeetdholakia.androidmvvmdagger.ui.main.profile.ProfileViewModel

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
}