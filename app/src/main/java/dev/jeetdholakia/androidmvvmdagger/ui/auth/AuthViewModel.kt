package dev.jeetdholakia.androidmvvmdagger.ui.auth

import android.util.Log
import androidx.lifecycle.*
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.network.auth.AuthApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi) : ViewModel() {

    private val TAG: String = "AuthViewModel"
    private val authApi: AuthApi

    private var authUser: MediatorLiveData<User> = MediatorLiveData()

    init {
        this.authApi = authApi
        Log.d(TAG, "Inside AuthVM")
        authApi.getUser(1)
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnNext {}
            .subscribe({user -> Log.d(TAG, "User Exists! ${user.getUserName()}")}, { throwable -> Log.e(TAG, "error!! ${throwable.localizedMessage}")})
    }

    fun authenticateUser(userID: Int) {
        val source: LiveData<User> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(1)
                .subscribeOn(Schedulers.io())
        )

        authUser.addSource(source, Observer<User>() {
            Log.d(TAG, "Inside on changed")
                authUser.setValue(it)
                authUser.removeSource(source)

        })
    }

    fun observeUser(): LiveData<User> {
        return authUser
    }
}