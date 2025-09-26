package com.metatribe.content.feed.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.metatribe.content.feed.data.converter.PostConverter
import com.metatribe.content.feed.domain.vo.PostVO

class HomeViewModel : ViewModel() {

    private lateinit var converter: PostConverter

    private val _posts = MutableLiveData<MutableList<PostVO>>()
    val posts: LiveData<MutableList<PostVO>> = _posts

    fun fetchPosts() {
        FirebaseFirestore.getInstance()
            .collection("posts")
            .orderBy("createdPost", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                val postList = result.map { doc ->
                    PostVO(
                        userName = doc.getString("userName") ?: "",
                        userImageAvatar = doc.getString("userImageAvatar") ?: "",
                        imagePost = doc.getString("imagePost") ?: "",
                        descriptionPost = doc.getString("descriptionPost") ?: "",
                        createdPost = doc.getTimestamp("createdPost") ?: Timestamp.now()
                    )
                }
                _posts.value = postList.toMutableList()
            }
    }

//    fun saveNewPost(imagePost: String, description: String, localDataSource: LocalDataSource) {
//        converter = PostConverter()
//        createPostFirebase(converter.convert(imagePost, description, localDataSource))
//    }

    private fun createPostFirebase(post: PostVO) {
        val db = FirebaseFirestore.getInstance()
        val postMap = hashMapOf(
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


