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

@Module
class AppModule {

    companion object {
        @Provides
        fun requestOptions(): RequestOptions {
            return RequestOptions().
            placeholder(R.drawable.white_background).
            error(R.drawable.white_background)
        }

        @Provides
        fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Provides
        fun provideAppDrawable(application: Application): Drawable {
            return ContextCompat.getDrawable(application, R.drawable.logo)!!
        }
    }
}