package com.abaza_vg.binlist.domain

data class Country(
    var numeric: String,
    var alpha2: String,
    var name: String,
    var emoji: String,
    var currency: String,
    var latitude: Int,
    var longitude: Int
)
