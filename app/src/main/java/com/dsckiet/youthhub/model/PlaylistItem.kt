package com.dsckiet.youthhub.model

data class PlaylistItem(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)
