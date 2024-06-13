// FactureRepository.kt
package com.b3g.fawri.minibank.domain.repositories

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Facture

interface FactureRepository {
    suspend fun getFactures(): RequestResult<List<Facture>, RootError>
}
