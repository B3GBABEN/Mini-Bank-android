package com.b3g.fawri.minibank.data.remote.moels

// Facture.kt

data class Facture(
    val date: String,
    val name: String,
    val reference: String,
    val amount: String,
    val status: String,
    val factureId : Int,
)

