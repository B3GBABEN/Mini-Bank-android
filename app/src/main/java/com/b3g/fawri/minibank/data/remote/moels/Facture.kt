package com.b3g.fawri.minibank.data.remote.moels

data class Facture(
    val date: String,
    val description: String,
    val amount: Double,
    val factureId: String,
    val status: String
)
