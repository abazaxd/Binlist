package com.abaza_vg.binlist.data

import com.abaza_vg.binlist.domain.Bank
import com.abaza_vg.binlist.domain.Country
import com.abaza_vg.binlist.domain.Number

data class CardInfoDTO(
    val number: Number?,
    val country: Country?,
    val bank: Bank?,
    val bin: String?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?
)
