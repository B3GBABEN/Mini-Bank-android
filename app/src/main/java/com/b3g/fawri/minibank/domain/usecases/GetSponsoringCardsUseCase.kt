package com.b3g.fawri.minibank.domain.usecases

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.domain.repositories.HomeRepository
import javax.inject.Inject

class GetSponsoringCardsUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): RequestResult<List<SponsoringCard>, RootError> {
        return repository.getSponsoringCards()
    }
}
