package com.b12game.exammodul6.network

import com.b12game.exammodul6.network.service.CardService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    private const val IS_TESTER = true
    private const val SERVER_DEVELOPMENT = "https://623302e06de3467dbac5ccfa.mockapi.io/"
    private const val SERVER_PRODUCTION = "https://623302e06de3467dbac5ccfa.mockapi.io/"

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val cardService: CardService =  retrofit.create(CardService::class.java)
}