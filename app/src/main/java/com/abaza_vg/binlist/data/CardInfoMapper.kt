package com.abaza_vg.binlist.data

import com.abaza_vg.binlist.domain.Bank
import com.abaza_vg.binlist.domain.CardInfo
import com.abaza_vg.binlist.domain.Country
import com.abaza_vg.binlist.domain.Number
import javax.inject.Inject

class CardInfoMapper @Inject constructor() {

    fun mapCardInfoDTOtoCardInfo(cardInfoDTO: CardInfoDTO): CardInfo {
        return CardInfo(
            number = cardInfoDTO.number,
            country = cardInfoDTO.country,
            bank = cardInfoDTO.bank,
            scheme = cardInfoDTO.scheme,
            type = cardInfoDTO.type,
            brand = cardInfoDTO.brand,
            prepaid = cardInfoDTO.prepaid,
            bin = cardInfoDTO.bin
        )
    }

    fun mapCardInfoToCardInfoDbModel(cardInfo: CardInfo): CardInfoDbModel {
        return CardInfoDbModel(
            scheme = cardInfo.scheme,
            type = cardInfo.type,
            brand = cardInfo.brand,
            prepaid = cardInfo.prepaid,
            numeric = cardInfo.country?.numeric,
            alpha2 = cardInfo.country?.alpha2,
            bankName = cardInfo.bank?.name,
            emoji = cardInfo.country?.emoji,
            currency = cardInfo.country?.currency,
            latitude = cardInfo.country?.latitude,
            longitude = cardInfo.country?.longitude,
            countryName = cardInfo.country?.name,
            url = cardInfo.bank?.url,
            phone = cardInfo.bank?.phone,
            city = cardInfo.bank?.city,
            length = cardInfo.number?.length,
            luhn = cardInfo.number?.luhn,
            bin = cardInfo.bin
        )
    }

    fun mapCardInfoDbModelToCardInfo(cardInfoDbModel: CardInfoDbModel): CardInfo {

        val number = Number(
            length = cardInfoDbModel.length,
            luhn = cardInfoDbModel.luhn
        )

        val bank = Bank(
            name = cardInfoDbModel.bankName,
            url = cardInfoDbModel.url,
            phone = cardInfoDbModel.phone,
            city = cardInfoDbModel.city
        )

        val country = Country(
            numeric = cardInfoDbModel.numeric,
            alpha2 = cardInfoDbModel.alpha2,
            name = cardInfoDbModel.countryName,
            emoji = cardInfoDbModel.emoji,
            currency = cardInfoDbModel.currency,
            latitude = cardInfoDbModel.latitude,
            longitude = cardInfoDbModel.longitude
        )
        return CardInfo(
            number = number,
            country = country,
            bank = bank,
            scheme = cardInfoDbModel.scheme,
            type = cardInfoDbModel.type,
            brand = cardInfoDbModel.brand,
            prepaid = cardInfoDbModel.prepaid,
            bin = cardInfoDbModel.bin
        )
    }

    fun mapCardInfoDbModelListToCardInfoList(list: List<CardInfoDbModel>) = list.map {
        mapCardInfoDbModelToCardInfo(it)
    }
}