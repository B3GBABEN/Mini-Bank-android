package com.b3g.fawri.minibank.domain.repositories

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard

interface SponsorRepository {
    suspend fun getSponsoringCards(): RequestResult<List<SponsoringCard>, RootError>

}