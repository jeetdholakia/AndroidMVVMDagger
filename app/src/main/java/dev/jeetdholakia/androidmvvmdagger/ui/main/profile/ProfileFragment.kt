package dev.jeetdholakia.androidmvvmdagger.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.models.User
import dev.jeetdholakia.androidmvvmdagger.ui.auth.AuthResource
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_profile.*
import timber.log.Timber
import javax.inject.Inject

class ProfileFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated: Profile fragment created")
        profileViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(ProfileViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        profileViewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        profileViewModel.getAuthenticatedUser().observe(viewLifecycleOwner, Observer {
            it.let {
                when (it.status) {
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        setUserDetails(it.data)
                    }
                    AuthResource.AuthStatus.ERROR -> {
                        setErrorDetails(it.message)
                    } else -> {
                    Timber.d("Nada")
                }
                }
            }
        })
    }

    private fun setErrorDetails(message: String?) {
        emailTextView.text = message
        usernameTextView.text = resources.getString(R.string.error)
        websiteTextView.text = resources.getString(R.string.error)
    }

    private fun setUserDetails(user: User?) {
        emailTextView.text = user?.email
        usernameTextView.text = user?.username
        websiteTextView.text = user?.website
    }



}