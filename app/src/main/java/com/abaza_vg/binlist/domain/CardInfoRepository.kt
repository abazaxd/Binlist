package com.abaza_vg.binlist.domain

import androidx.lifecycle.LiveData
import com.abaza_vg.binlist.data.CardInfoDbModel

interface CardInfoRepository {

    suspend fun getCardInfo(bin: String): CardInfo

    fun saveCardInfoToHistory(cardInfo: CardInfo)

    fun getHistory(): LiveData<List<CardInfoDbModel>>
}