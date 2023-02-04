data class Likes(
    var count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Post(
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val id: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val markedAsAds: Boolean = false,
    val likes: Likes = Likes()
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = 2 + posts.lastIndex)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun printAllPosts () {
        for (post in posts) {
            println(post)
        }
    }

    fun clear() {
        posts = emptyArray()
    }
}

fun main() {
    WallService.add(Post(11111, 22222, 33333, 44444, "Hello!"))
    WallService.add(Post(99999, 88888, 77777, 66666, "Bye!"))
    WallService.add(Post(55555, 44444, 66666, 88888, "Hi!"))

    WallService.printAllPosts()
}