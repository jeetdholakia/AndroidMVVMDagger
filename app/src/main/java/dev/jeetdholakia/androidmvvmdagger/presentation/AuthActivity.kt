package dev.jeetdholakia.androidmvvmdagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import dev.jeetdholakia.androidmvvmdagger.R
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var superString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Log.d("TAG", superString)

    }
}
