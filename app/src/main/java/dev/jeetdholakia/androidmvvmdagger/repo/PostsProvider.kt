package dev.jeetdholakia.androidmvvmdagger.repo

import dev.jeetdholakia.androidmvvmdagger.models.Post

class PostsProvider {
    companion object {
        fun getPosts(): List<Post>{
            return  listOf(Post(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"),
                    Post(1, 2, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"))
        }
    }
}