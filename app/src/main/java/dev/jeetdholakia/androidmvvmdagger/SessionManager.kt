package dev.jeetdholakia.androidmvvmdagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthResource
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private var cachedUser: MediatorLiveData<AuthResource<out User>> = MediatorLiveData()

     fun authenticateWithId(source: LiveData<AuthResource<out User>>) {
        if (cachedUser != null) {
            cachedUser.value = AuthResource.Loading(null)
            cachedUser.addSource(source, Observer {
                cachedUser.value = it
                cachedUser.removeSource(source)
            })
        }
    }

    fun getAuthUser(): LiveData<AuthResource<out User>> {
        return cachedUser
    }

    fun logOut() {
        Timber.d("logOut: logging out...")
        cachedUser.value = AuthResource.Logout()
    }


}