package dev.jeetdholakia.androidmvvmdagger.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.jeetdholakia.androidmvvmdagger.ui.main.posts.PostsFragment
import dev.jeetdholakia.androidmvvmdagger.ui.main.profile.ProfileFragment

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment
}