package com.abaza_vg.binlist.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.abaza_vg.binlist.data.retrofit.API
import com.abaza_vg.binlist.data.retrofit.RetrofitClient
import com.abaza_vg.binlist.data.room.AppDatabase
import com.abaza_vg.binlist.domain.CardInfo
import com.abaza_vg.binlist.domain.CardInfoRepository

class CardInfoRepositoryImpl(application: Application): CardInfoRepository {

    private val dao = AppDatabase.getInstance(application).cardInfoDao()
    private val api = RetrofitClient.getClient().create(API::class.java)
    private val mapper = CardInfoMapper()

    override suspend fun getCardInfo(bin: String): CardInfo {
        return mapper.mapCardInfoDTOtoCardInfo(api.getCardInfo(bin))
    }

    override fun saveCardInfoToHistory(cardInfo: CardInfo) {
        dao.addCardInfo(mapper.mapCardInfoToCardInfoDbModel(cardInfo))
    }

    override fun getHistory(): LiveData<List<CardInfoDbModel>> {
        return dao.getCardInfoList()
    }
}