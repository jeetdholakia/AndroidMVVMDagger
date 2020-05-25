package dev.jeetdholakia.androidmvvmdagger.ui.auth

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var appLogo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel::class.java)

        authViewModel = ViewModelProvider.NewInstanceFactory().create(AuthViewModel::class.java)

        setLogo()
    }

    private fun setLogo() {
        requestManager.load(appLogo).into(findViewById<ImageView>(R.id.login_logo))
    }
}
