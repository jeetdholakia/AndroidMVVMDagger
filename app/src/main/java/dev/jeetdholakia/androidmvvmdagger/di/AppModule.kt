package dev.jeetdholakia.androidmvvmdagger.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dev.jeetdholakia.androidmvvmdagger.R
import javax.inject.Singleton

@Module
class AppModule {

    companion object {
        @Singleton
        @Provides
        fun requestOptions(): RequestOptions {
            return RequestOptions().
            placeholder(R.drawable.white_background).
            error(R.drawable.white_background)
        }

        @Singleton
        @Provides
        fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Singleton
        @Provides
        fun provideAppDrawable(application: Application): Drawable {
            return ContextCompat.getDrawable(application, R.drawable.logo)!!
        }
    }
}