package com.summerlockin.bookmark.Tabitha.controller

import com.summerlockin.bookmark.Tabitha.database.model.Bookmark
import com.summerlockin.bookmark.Tabitha.database.repository.BookmarkRepository
import com.summerlockin.bookmark.Tabitha.dto.BookmarkRequest
import com.summerlockin.bookmark.Tabitha.dto.BookmarkResponse
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/api/bookmarks")
class BookmarkController (
     private val repository: BookmarkRepository
){

     @PostMapping
     fun save(@RequestBody body : BookmarkRequest) : BookmarkResponse{
          val bookmark = repository.save(
               Bookmark(
                    url = body.url,
                    category = body.category,
                    previewImageUrl = body.previewImageUrl,
                    createdAt = Instant.now(),
                    ownerId = ObjectId()

               )
          )
     return bookmark.toResponse()

     }
     @GetMapping
     fun findbyOwnerId(
          @RequestParam(required = true) ownerId:String
     ):List<BookmarkResponse>{
         return repository.findByOwnerId(ObjectId(ownerId)).map{
               it.toResponse()
         }
     }

     @DeleteMapping(path = ["/{id}"])
     fun deleteById(@PathVariable id :String){
          repository.deleteById(ObjectId(id))
     }

     private fun Bookmark.toResponse():BookmarkResponse{
          return BookmarkResponse(
               id = id.toHexString(),
               url = url,
               category = category,
               createdAt = createdAt,
               previewImageUrl = previewImageUrl,
               trashed = false

          )
     }
}