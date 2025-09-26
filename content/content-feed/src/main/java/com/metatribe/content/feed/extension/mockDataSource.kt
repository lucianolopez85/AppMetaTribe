package com.metatribe.content.feed.extension

import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.CarouselItem
import com.metatribe.content.feed.domain.vo.CommunityItem

val mockData = listOf(
    CommunityItem.CarouselContainer(
        title = "Grupos em destaque",
        items = listOf(
            CarouselItem(R.drawable.maromba_fit, "Maromba Fit", "Florianópolis", 120, 30),
            CarouselItem(R.drawable.corrida_bm, "Corredores SC", "Joinville", 80, 45)
        )
    ),
    CommunityItem.CarouselContainer(
        title = "Desafios Ativos",
        items = listOf(
            CarouselItem(R.drawable.volta_ilha  , "Volta na Ilha", "Florianópolis", 60, 10),
            CarouselItem(R.drawable.pedal_bm, "Pedal na beira mar", "Florianópolis", 40, 5)
        )
    ),
    CommunityItem.CarouselContainer(
        title = "Próximos Desafios",
        items = listOf(
            CarouselItem(R.drawable.travessia_canas, "Travessia em Canas", "Florianópolis", 12, 0),
            CarouselItem(R.drawable.corrida_jurere, "Corrida em Jurerê", "Florianópolis", 16, 0)
        )
    )
)