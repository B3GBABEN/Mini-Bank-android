// FactureRepositoryImpl.kt
package com.b3g.fawri.minibank.data.repositories

import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Facture
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.FactureRepository
import javax.inject.Inject

class FactureRepositoryImpl @Inject constructor(
    private val api: ClientApi
) : FactureRepository {
    override suspend fun getFactures(): RequestResult<List<Facture>, RootError> {
        return try {
            val factures = listOf(
                Facture("Aujourd'hui", "Facture Redal", "100000914451", "500,00 MAD", "Reçu",1),
                Facture("28/04/2024", "Facture Redal", "500,00 MAD", "500,00 MAD", "Reçu",2),
            )
            RequestResult.Success(factures)
        } catch (e: Exception) {
            RequestResult.Error(DataError.Network.FACTURE_ERROR)
        }
    }
}
