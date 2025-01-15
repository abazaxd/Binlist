package com.abaza_vg.binlist.data

import com.abaza_vg.binlist.domain.CardInfo

class CardInfoMapper {

    fun mapCardInfoDTOtoCardInfo(cardInfoDTO: CardInfoDTO): CardInfo {
        return CardInfo(
            number = cardInfoDTO.number,
            country = cardInfoDTO.country,
            bank = cardInfoDTO.bank,
            scheme = cardInfoDTO.scheme,
            type = cardInfoDTO.type,
            brand = cardInfoDTO.brand,
            prepaid = cardInfoDTO.prepaid
        )
    }
}