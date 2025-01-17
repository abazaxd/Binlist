package com.abaza_vg.binlist.domain

data class CardInfo(
    val number: Number,
    val country: Country,
    val bank: Bank,
    val bin: String,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    var id: Int = -1
)
