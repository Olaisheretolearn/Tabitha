package com.summerlockin.bookmark.Tabitha.dto

import org.bson.types.ObjectId

data class BookmarkRequest(
    val id:String?,
    val url: String,
    val category: String,
    val previewImageUrl: String? = null,
    val ownerId: String? = null


)
