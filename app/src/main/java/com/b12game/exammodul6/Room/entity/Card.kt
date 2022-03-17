package com.b12game.exammodul6.Room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Card")
data class Card(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    val cardName: String? = null,
    val cardNumber: String? = null,
    val cardDate: String? = null,
    val cvv: String? = null,
)