package com.metatribe.content.feed.data.converter

import com.metatribe.content.feed.domain.vo.PostVO
import com.metatribe.content.feed.domain.vo.UserVO
import java.util.UUID

class PostConverter {

    fun convert(imagePost: String, descriptionPost: String, user: UserVO): PostVO {
        return PostVO(
            postId = UUID.randomUUID().toString(),
            userName = user.userName,
            userImageAvatar = user.userImgAvatar,
            imagePost = imagePost,
            descriptionPost = descriptionPost,
            createdPost = com.google.firebase.Timestamp.now()
        )
    }
}