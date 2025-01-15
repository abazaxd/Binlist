package com.abaza_vg.binlist.data

import com.abaza_vg.binlist.data.retrofit.API
import com.abaza_vg.binlist.data.retrofit.RetrofitClient
import com.abaza_vg.binlist.domain.CardInfo
import com.abaza_vg.binlist.domain.CardInfoRepository

object CardInfoRepositoryImpl: CardInfoRepository {

    private val api = RetrofitClient.getClient().create(API::class.java)
    private val mapper = CardInfoMapper()

    override suspend fun getCardInfo(bin: String): CardInfo {
        return mapper.mapCardInfoDTOtoCardInfo(api.getCardInfo(bin))
    }

    override fun saveCardInfoToHistory(cardInfo: CardInfo) {
        TODO("Not yet implemented")
    }

    override fun getHistory(): List<CardInfo> {
        TODO("Not yet implemented")
    }
}