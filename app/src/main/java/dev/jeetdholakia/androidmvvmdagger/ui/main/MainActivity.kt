package dev.jeetdholakia.androidmvvmdagger.ui.main

import android.os.Bundle
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
