package com.summerlockin.bookmark.Tabitha.database.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("bookmarks")
data class Bookmark(
    val url: String,
    val createdAt: Instant,
    val category: String,
    val ownerId : ObjectId,
    val previewImageUrl: String? = null,
    val trashed: Boolean = false,
    @Id val id: ObjectId = ObjectId.get(),

)