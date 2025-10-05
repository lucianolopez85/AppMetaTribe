package com.metatribe.content.feed.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.metatribe.content.feed.domain.vo.PostVO
import java.util.UUID

class HomeViewModel : ViewModel() {

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
                        postId = doc.getString("postId") ?: UUID.randomUUID().toString(),
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
}
