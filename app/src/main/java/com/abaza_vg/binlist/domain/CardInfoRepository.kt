package com.abaza_vg.binlist.domain

interface CardInfoRepository {

    suspend fun getCardInfo(bin: String): CardInfo

    fun saveCardInfoToHistory(cardInfo: CardInfo)

    fun getHistory(): List<CardInfo>
}