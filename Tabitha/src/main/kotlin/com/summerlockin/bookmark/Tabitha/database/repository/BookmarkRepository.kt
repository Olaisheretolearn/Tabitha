package com.summerlockin.bookmark.Tabitha.database.repository

import com.summerlockin.bookmark.Tabitha.database.model.Bookmark
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface BookmarkRepository : MongoRepository<Bookmark, ObjectId> {

}