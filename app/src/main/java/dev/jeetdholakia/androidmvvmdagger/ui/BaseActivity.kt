package dev.jeetdholakia.androidmvvmdagger.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import dev.jeetdholakia.androidmvvmdagger.SessionManager
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthActivity
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthResource
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer {
            if(it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {

                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        //Timber.d("User authed")

                    }
                    AuthResource.AuthStatus.ERROR -> {
                        //Timber.e("User auth error: ${it.message}")
                        //Toast.makeText(this, it.message + "Error in authenticating", Toast.LENGTH_SHORT).show()
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        //Timber.d("User logged out")
                        navigateToLoginScreen()
                    }
                }
            }
        })
    }

    private fun navigateToLoginScreen() {
        var intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}