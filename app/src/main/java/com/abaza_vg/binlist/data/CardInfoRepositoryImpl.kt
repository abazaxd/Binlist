package com.abaza_vg.binlist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.abaza_vg.binlist.data.retrofit.API
import com.abaza_vg.binlist.data.room.CardInfoDAO
import com.abaza_vg.binlist.domain.CardInfo
import com.abaza_vg.binlist.domain.CardInfoRepository
import javax.inject.Inject

class CardInfoRepositoryImpl @Inject constructor(
    private val dao: CardInfoDAO,
    private val mapper: CardInfoMapper,
    private val api: API
): CardInfoRepository {



    override suspend fun getCardInfo(bin: String): CardInfo {
        val cardInfo = mapper.mapCardInfoDTOtoCardInfo(api.getCardInfo(bin))
        cardInfo.bin = bin
        return cardInfo
    }

    override suspend fun saveCardInfoToHistory(cardInfo: CardInfo) {
        dao.addCardInfo(mapper.mapCardInfoToCardInfoDbModel(cardInfo))
    }

    override fun getHistory(): LiveData<List<CardInfo>> = MediatorLiveData<List<CardInfo>>().apply {
        addSource(dao.getCardInfoList()) {
            value = mapper.mapCardInfoDbModelListToCardInfoList(it)
        }
    }
}