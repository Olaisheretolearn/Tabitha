package com.summerlockin.bookmark.Tabitha.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService (
   @Value("JWT_SECRET_64") private  val jwtSecret:String
){
    private val secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtSecret))
    private val accessTokenValidityMs = 15L * 60L *  1000L
     val refreshTokenValidityMs = 30L * 24 * 60 * 60 * 1000L

     private fun generateToken(
         userId:String,
         type:String, // like wehat type of token are we generating
         expiry:Long
     ):String{
         val now = Date()
         val expiryDate = Date(now.time + expiry)
         return Jwts.builder()
             .subject(userId) //owner of the token
             .claim("type", type)
             .signWith(secretKey, Jwts.SIG.HS256)
             .compact()
     }

    fun generateAccesSToken(userId:String) :String {
        return generateToken(userId, "access", accessTokenValidityMs)
    }

    fun generateRefreshToken(userId:String) :String {
        return generateToken(userId, "refresh", refreshTokenValidityMs)
    }

    fun validateAccessToken(token:String):Boolean {

    }

    private fun parseAllClaims(token:String): Claims?{
        return try{
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .payload()
        } catch(e:Exception){

        }
    }

}