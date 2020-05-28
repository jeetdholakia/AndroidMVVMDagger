package dev.jeetdholakia.androidmvvmdagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import dev.jeetdholakia.androidmvvmdagger.SessionManager
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.network.auth.AuthApi
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val authApi: AuthApi, sessionManager: SessionManager) : ViewModel() {

    private val TAG: String = "AuthViewModel"
    private var sessionManager = sessionManager

    fun authenticateUser(userID: Int) {
        Timber.d("Attempting to authenticate the user...")
        sessionManager.authenticateWithId(queryUserId(userID))
    }

    private fun queryUserId(userID: Int): LiveData<AuthResource<out User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userID).onErrorReturn {
                return@onErrorReturn User(-1, null, null, null)
            }.map {
                if (it.id == -1) {
                    return@map AuthResource.Error("Could not authenticate", null)
                } else {
                    return@map AuthResource.Authenticated(it)
                }
            }.subscribeOn(Schedulers.io()))
    }

    fun observeAuthState(): LiveData<AuthResource<out User>> {
        return sessionManager.getAuthUser()
    }
}