package com.abaza_vg.binlist.domain

import javax.inject.Inject

class SaveCardInfoToHistoryUseCase @Inject constructor(private val cardInfoRepository: CardInfoRepository) {

    suspend fun saveCardInfoToHistory(cardInfo:CardInfo) {
        cardInfoRepository.saveCardInfoToHistory(cardInfo)
    }
}