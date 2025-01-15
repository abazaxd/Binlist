package com.abaza_vg.binlist.domain

class GetCardInfoUseCase(private val cardInfoRepository: CardInfoRepository) {

    suspend fun getCardInfo(bin: String): CardInfo {
        return cardInfoRepository.getCardInfo(bin)
    }
}