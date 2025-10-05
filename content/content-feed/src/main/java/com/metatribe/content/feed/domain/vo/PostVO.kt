package com.metatribe.content.feed.domain.vo

data class PostVO(
    val postId: String,
    val userName: String,
    val userImageAvatar: String,
    val imagePost: String,
    val descriptionPost: String,
    val createdPost: com.google.firebase.Timestamp
)
