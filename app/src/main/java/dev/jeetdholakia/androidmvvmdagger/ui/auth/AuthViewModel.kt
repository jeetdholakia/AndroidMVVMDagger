package dev.jeetdholakia.androidmvvmdagger.ui.auth

import androidx.lifecycle.*
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.network.auth.AuthApi
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi) : ViewModel() {

    private val TAG: String = "AuthViewModel"
    private var authUser: MediatorLiveData<User> = MediatorLiveData()

    fun authenticateUser(userID: Int) {
        val source: LiveData<User> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userID)
                .subscribeOn(Schedulers.io())
        )

        authUser.addSource(source, Observer<User>() {
                authUser.setValue(it)
                authUser.removeSource(source)

        })
    }

    fun observeUser(): LiveData<User> {
        return authUser
    }
}