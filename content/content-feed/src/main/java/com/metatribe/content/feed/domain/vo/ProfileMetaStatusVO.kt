package com.metatribe.content.feed.domain.vo

import com.metatribe.content.feed.data.StatusMeta

data class ProfileMetaStatusVO(
    val status: StatusMeta,
    val emoji: String,
    val colorRes: Int,
    val description: String
)
