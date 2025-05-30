package com.summerlockin.bookmark.Tabitha.database.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("users")
data class User(
    @Id val id: ObjectId = ObjectId(),

    val email: String,
    val hashedpassword: String,

    val avatarUrl: String? = null,
    val createdAt: Instant = Instant.now()
)

