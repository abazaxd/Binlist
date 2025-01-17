package com.abaza_vg.binlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_infos")
data class CardInfoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bin: String,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val numeric: String,
    val alpha2: String,
    val bankName: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
    val countryName: String,
    val url: String,
    val phone: String,
    val city: String,
    val length: String,
    val luhn: String
)
