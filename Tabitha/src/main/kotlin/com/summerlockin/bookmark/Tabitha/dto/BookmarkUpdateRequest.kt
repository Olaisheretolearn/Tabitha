package com.summerlockin.bookmark.Tabitha.dto

data class BookmarkUpdateRequest(
    val url: String?,
    val category: String?,
    val previewImageUrl: String? = null,

)
