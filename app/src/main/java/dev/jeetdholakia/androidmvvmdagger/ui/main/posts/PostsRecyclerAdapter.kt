package dev.jeetdholakia.androidmvvmdagger.ui.main.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.jeetdholakia.androidmvvmdagger.R
import dev.jeetdholakia.androidmvvmdagger.models.Post

class PostsRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var posts: List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_list_item, parent, false)
        return PostsRecyclerAdapter.PostsViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostsViewHolder).bind(
            posts[position]
        )
    }

    public fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)

        fun bind(post: Post) {
            title.text = post.title
        }

    }
}