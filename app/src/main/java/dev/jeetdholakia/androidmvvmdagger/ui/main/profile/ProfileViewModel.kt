package dev.jeetdholakia.androidmvvmdagger.ui.main.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.jeetdholakia.androidmvvmdagger.SessionManager
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthResource
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private var sessionManager: SessionManager): ViewModel() {

    init {
        Timber.d("Profile view model is ready!")
    }

    fun getAuthenticatedUser(): LiveData<AuthResource<out User>> {
        return sessionManager.getAuthUser()
    }
}