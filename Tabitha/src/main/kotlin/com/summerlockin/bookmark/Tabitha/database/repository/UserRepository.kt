package com.summerlockin.bookmark.Tabitha.database.repository

import com.summerlockin.bookmark.Tabitha.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface  UserRepository : MongoRepository<User, ObjectId> {
    fun findByEmail(email:String):User?
}