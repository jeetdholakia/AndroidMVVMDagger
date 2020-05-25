package dev.jeetdholakia.androidmvvmdagger.presentation

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import dev.jeetdholakia.androidmvvmdagger.R
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var appLogo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setLogo()
    }

    private fun setLogo() {
        requestManager.load(appLogo).into(findViewById<ImageView>(R.id.login_logo))
    }
}
