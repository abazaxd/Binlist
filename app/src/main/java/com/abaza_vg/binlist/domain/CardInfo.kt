package com.abaza_vg.binlist.domain

data class CardInfo(
    val number: Number?,
    val country: Country?,
    val bank: Bank?,
    var bin: String?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?
)
