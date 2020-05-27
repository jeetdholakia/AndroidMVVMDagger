package dev.jeetdholakia.androidmvvmdagger.ui.auth

// A generic class that contains data and status about loading this data.
sealed class AuthResource<T>(
    val status: AuthStatus,
    val data: T? = null,
    val message: String? = null
) {
   class Authenticated<T>(data: T) :
      AuthResource<T>(AuthStatus.AUTHENTICATED, data, null)

   class Error<T>(message: String, data: T? = null) :
      AuthResource<T>(AuthStatus.ERROR, data, message)

   class Loading<T>(data: T? = null) :
      AuthResource<T>(AuthStatus.LOADING, data, null)

   class Logout<T>() :
      AuthResource<T>(AuthStatus.NOT_AUTHENTICATED, null, null)

   enum class AuthStatus {
      AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
   }
}
