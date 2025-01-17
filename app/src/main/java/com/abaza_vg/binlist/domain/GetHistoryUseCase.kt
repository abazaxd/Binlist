package com.abaza_vg.binlist.domain

import androidx.lifecycle.LiveData
import com.abaza_vg.binlist.data.CardInfoDbModel

class GetHistoryUseCase(private val cardInfoRepository: CardInfoRepository) {

    fun getHistory(): LiveData<List<CardInfoDbModel>> {
        return cardInfoRepository.getHistory()
    }
}