package com.abaza_vg.binlist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val cardInfoRepository: CardInfoRepository) {

    fun getHistory(): LiveData<List<CardInfo>> {
        return cardInfoRepository.getHistory()
    }
}