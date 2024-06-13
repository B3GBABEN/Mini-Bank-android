// GetFacturesUseCase.kt
package com.b3g.fawri.minibank.domain.usecases

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Facture
import com.b3g.fawri.minibank.domain.repositories.FactureRepository
import javax.inject.Inject

class GetFacturesUseCase @Inject constructor(
    private val repository: FactureRepository
) {
    suspend operator fun invoke(): RequestResult<List<Facture>, RootError> {
        return repository.getFactures()
    }
}
