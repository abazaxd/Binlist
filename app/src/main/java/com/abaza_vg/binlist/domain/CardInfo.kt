package com.abaza_vg.binlist.domain

data class CardInfo(
    var number: Number,
    var country: Country,
    var bank: Bank,
    var scheme: String,
    var type: String,
    var brand: String,
    var prepaid: Boolean
)
