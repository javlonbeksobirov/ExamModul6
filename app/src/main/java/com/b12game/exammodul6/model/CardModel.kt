package com.b12game.exammodul6.model

import androidx.room.Entity


data class CardAppModel(
    val cardName: String? = null,
    val cardNumber: String? = null,
    val cardDate: String? = null,
    val cvv: String? = null,
    val id: String? = null
)