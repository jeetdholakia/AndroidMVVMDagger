package dev.jeetdholakia.androidmvvmdagger.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.ui.main.Resource
import dev.jeetdholakia.androidmvvmdagger.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_posts.*
import timber.log.Timber
import javax.inject.Inject

class PostsFragment: DaggerFragment() {

    private lateinit var postsViewModel: PostsViewModel
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    @Inject
    lateinit var postsRecyclerAdapter: PostsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postsViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(
            PostsViewModel::class.java)
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        postsViewModel.observePosts().removeObservers(viewLifecycleOwner)
        postsViewModel.observePosts().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        Timber.d("Success in fetching posts")
                            postsRecyclerAdapter.setPosts(it.data!!)
                    }
                    Resource.Status.LOADING -> {
                        Timber.d("Loading posts...")
                    }
                    Resource.Status.ERROR -> {
                        Timber.e("Error in fetching posts")
                    }
                }
            }
        })
    }

    private fun initRecyclerView() {
        postsRecyclerView.layoutManager = LinearLayoutManager(activity)
        postsRecyclerView.adapter = postsRecyclerAdapter

    }
}