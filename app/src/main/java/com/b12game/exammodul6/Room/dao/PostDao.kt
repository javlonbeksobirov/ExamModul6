package com.b12game.exammodul6.Room.dao

import androidx.room.*
import com.b12game.exammodul6.Room.entity.Card
import com.b12game.exammodul6.model.CardAppModel

@Dao
interface PostDao {

    @Insert
    fun createPost(card:Card)

    @Query("SELECT * FROM card")
    fun getPost():List<Card>

    @Query("SELECT * FROM card WHERE id=:id")
    fun getPostById(id:Int):Card

    @Delete
    fun deletePostWithDelete(card:Card)

    @Query("DELETE FROM card WHERE id=:id")
    fun deletepostWithQuery(id:Int)

}