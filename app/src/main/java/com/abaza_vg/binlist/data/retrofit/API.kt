package com.abaza_vg.binlist.data.retrofit

import com.abaza_vg.binlist.data.CardInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("{bin}")
    suspend fun getCardInfo(@Path("bin") bin: String): CardInfoDTO
}