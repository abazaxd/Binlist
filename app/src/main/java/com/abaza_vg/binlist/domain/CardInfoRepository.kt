package com.abaza_vg.binlist.domain

import androidx.lifecycle.LiveData

interface CardInfoRepository {

    suspend fun getCardInfo(bin: String): CardInfo

    suspend fun saveCardInfoToHistory(cardInfo: CardInfo)

    fun getHistory(): LiveData<List<CardInfo>>
}