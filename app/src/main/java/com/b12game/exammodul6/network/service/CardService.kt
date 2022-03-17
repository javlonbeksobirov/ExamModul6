package com.b12game.exammodul6.network.service

import com.b12game.exammodul6.model.CardAppModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CardService {

    @GET("cardname")
    fun getcards(): Call<ArrayList<CardAppModel>>


}