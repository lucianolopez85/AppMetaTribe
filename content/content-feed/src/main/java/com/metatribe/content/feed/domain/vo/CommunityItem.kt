package com.metatribe.content.feed.domain.vo

import androidx.annotation.DrawableRes


sealed class CommunityItem {

    data class CarouselContainer(
        val title: String,
        val items: List<CarouselItem>
    ) : CommunityItem()
}


data class CarouselItem(
    @DrawableRes val imageResId: Int? = null,
    val title: String,
    val location: String,
    val members: Int,
    val activeDays: Int
)
