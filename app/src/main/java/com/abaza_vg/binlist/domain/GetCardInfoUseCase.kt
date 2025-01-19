package com.abaza_vg.binlist.domain

import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(private val cardInfoRepository: CardInfoRepository) {

    suspend fun getCardInfo(bin: String): CardInfo {
        return cardInfoRepository.getCardInfo(bin)
    }
}