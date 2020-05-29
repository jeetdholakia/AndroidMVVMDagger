package dev.jeetdholakia.androidmvvmdagger.ui.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dev.jeetdholakia.androidmvvmdagger.SessionManager
import dev.jeetdholakia.androidmvvmdagger.models.Post
import dev.jeetdholakia.androidmvvmdagger.network.main.MainApi
import dev.jeetdholakia.androidmvvmdagger.repo.PostsProvider
import dev.jeetdholakia.androidmvvmdagger.ui.main.Resource
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val mainApi: MainApi,
    private val sessionManager: SessionManager
) : ViewModel() {

    private lateinit var posts: MediatorLiveData<Resource<List<Post>>>

    fun observePosts(): LiveData<Resource<List<Post>>> {
        posts = MediatorLiveData()
        posts.value = Resource.Loading()

        posts.value = Resource.Success(PostsProvider.getPosts())

//        val source: LiveData<Resource<List<Post>>> = LiveDataReactiveStreams.fromPublisher {
//            mainApi.getPostsFromUser(sessionManager.getAuthUser().value!!.data!!.id)
//                .onErrorReturn {
//                    Timber.d("Inside on error ${it.localizedMessage}")
//                    val post = Post(-1, -1, "", "")
//                    val posts = ArrayList<Post>()
//                    posts.add(post)
//                    return@onErrorReturn posts
//                }.map {
//                    Timber.d("Inside map")
//                    if (it.isNotEmpty()) {
//                        if (it[0].id == -1) {
//                            Timber.d("Inside map with error object")
//                            return@map Resource.Error("Something went wrong", null)
//                        }
//                    }
//                    return@map Resource.Success(posts)
//                }.subscribe({
//                    Timber.d("OnContinue man")
//                    Resource.Success(it)
//                }, {
//                    Timber.d("OnError man")
//                    Resource.Error("Something went wrong", null)
//                })
//        }
//
//        posts.addSource(source, androidx.lifecycle.Observer {
//            posts.value = it
//            posts.removeSource(source)
//
//        })

        return posts
    }

}