package dev.jeetdholakia.androidmvvmdagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.databinding.ActivityAuthBinding
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    @Inject
    lateinit var appLogo: Drawable
    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var authViewModel: AuthViewModel

    companion object {
        private val TAG = "AuthActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAuthBinding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        // Deprecated function but works for dagger 2
        authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel::class.java)

        // Newer version but dagger 2 having issues with this
        //authViewModel = ViewModelProvider.NewInstanceFactory().create(AuthViewModel::class.java)
        loginButton.setOnClickListener {
            Log.d(localClassName, "Login Button clicked!")
            authViewModel.authenticateUser(userIDEditText.text.toString().toInt())
        }
        setLogo()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        authViewModel.observeUser().observe(this, Observer {
            if(it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {
                        Log.d(TAG, "User auth loading")
                        showProgressBar(true)
                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        showProgressBar(false)
                        Log.d(TAG, "User authed ${it.data?.email}")
                    }
                    AuthResource.AuthStatus.ERROR -> {
                        showProgressBar(false)
                        Log.d(TAG, "User auth error")
                        Toast.makeText(this, it.message + "Error in authenticating", Toast.LENGTH_SHORT).show()
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> showProgressBar(false)
                }
            }
        })
    }

    private fun setLogo() {
        requestManager.load(appLogo).into(findViewById<ImageView>(R.id.login_logo))
    }

    private fun showProgressBar(isVisible: Boolean) {
        if (isVisible) {
            loadingProgressBar.visibility = View.VISIBLE
        } else {
            loadingProgressBar.visibility = View.GONE
        }
    }
}
