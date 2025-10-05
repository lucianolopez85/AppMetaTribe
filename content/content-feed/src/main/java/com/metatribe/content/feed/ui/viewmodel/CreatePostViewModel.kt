package com.metatribe.content.feed.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.metatribe.content.feed.data.converter.PostConverter
import com.metatribe.content.feed.domain.vo.PostVO
import com.metatribe.content.feed.domain.vo.UserVO
import java.util.UUID

class CreatePostViewModel : ViewModel() {

    private lateinit var converter: PostConverter

    fun saveNewPost(imagePost: String, description: String, userData: UserVO) {
        converter = PostConverter()
        createPostFirebase(converter.convert(imagePost, description, userData))
    }

    private fun createPostFirebase(post: PostVO) {
        val db = FirebaseFirestore.getInstance()
        val postMap = hashMapOf(
            "postId" to UUID.randomUUID().toString(),
            "userName" to post.userName,
            "userImageAvatar" to post.userImageAvatar,
            "imagePost" to post.imagePost,
            "descriptionPost" to post.descriptionPost,
            "createdPost" to Timestamp.now()
        )

        db.collection("posts")
            .add(postMap)
            .addOnSuccessListener { documentReference ->
                Log.d("Firestore", "Post criado com ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Erro ao criar post", e)
            }
    }
}