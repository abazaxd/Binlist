package com.abaza_vg.binlist.data

import com.abaza_vg.binlist.domain.Bank
import com.abaza_vg.binlist.domain.Country
import com.abaza_vg.binlist.domain.Number

class CardInfoDTO(
    var number: Number,
    var country: Country,
    var bank: Bank,
    var scheme: String,
    var type: String,
    var brand: String,
    var prepaid: Boolean
)
