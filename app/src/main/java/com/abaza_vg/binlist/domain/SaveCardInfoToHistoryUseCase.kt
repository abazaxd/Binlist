package com.abaza_vg.binlist.domain

class SaveCardInfoToHistoryUseCase(private val cardInfoRepository: CardInfoRepository) {

    fun saveCardInfoToHistory(cardInfo:CardInfo) {
        cardInfoRepository.saveCardInfoToHistory(cardInfo)
    }
}