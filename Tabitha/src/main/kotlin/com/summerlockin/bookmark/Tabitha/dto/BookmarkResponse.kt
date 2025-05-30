package com.summerlockin.bookmark.Tabitha.dto

import java.time.Instant

data class BookmarkResponse(
    val id: String,
    val url: String,
    val category: String,
    val createdAt: Instant,
    val previewImageUrl: String?,
    val trashed: Boolean
)

