package com.abaza_vg.binlist.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.abaza_vg.binlist.data.CardInfoDbModel

@Dao
interface CardInfoDAO {

    @Query("SELECT * FROM card_infos")
    fun getCardInfoList(): LiveData<List<CardInfoDbModel>>

    @Insert
    suspend fun addCardInfo(cardInfo: CardInfoDbModel)
}