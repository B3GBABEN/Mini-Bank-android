package com.b3g.fawri.minibank.data.repositories

import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.data.remote.moels.Transaction
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.SponsorRepository
import com.b3g.fawri.minibank.domain.repositories.TransactionRepository
import javax.inject.Inject

class SponsorRepositoryImpl @Inject constructor(
    private val api: ClientApi
) : SponsorRepository {
    override suspend fun getSponsoringCards(): RequestResult<List<SponsoringCard>, RootError> {
        return try {
            val sponsoringCards = listOf(
                SponsoringCard(id = 1, imageResId = R.drawable.card_image),
                SponsoringCard(id = 2, imageResId = R.drawable.card_image),
                SponsoringCard(id = 3, imageResId = R.drawable.card_image)
            )
            RequestResult.Success(sponsoringCards)
        } catch (e: Exception) {
            RequestResult.Error(DataError.Network.SPONSOR_ERROR)
        }

    }

}