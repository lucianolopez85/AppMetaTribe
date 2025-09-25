package com.metatribe.content.feed.domain.vo

import java.util.UUID

data class UserVO(
    val id: String = UUID.randomUUID().toString(),
    val userName: String,
    val userImage: String,
    val ObjectiveVO: List<ObjectiveVO>
)
