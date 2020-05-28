package dev.jeetdholakia.androidmvvmdagger.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.logout -> {
                sessionManager.logOut()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
