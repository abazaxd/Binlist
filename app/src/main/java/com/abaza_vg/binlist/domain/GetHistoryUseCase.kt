package com.abaza_vg.binlist.domain

class GetHistoryUseCase(private val cardInfoRepository: CardInfoRepository) {

    fun getHistory(): List<CardInfo>{
        return cardInfoRepository.getHistory()
    }
}