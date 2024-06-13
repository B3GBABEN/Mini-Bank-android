package com.b3g.fawri.minibank.presentation.screens.factures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b3g.fawri.minibank.data.remote.moels.Facture
import com.b3g.fawri.minibank.domain.usecases.GetFacturesUseCase
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoriqueFactureViewModel @Inject constructor(
    private val getFacturesUseCase: GetFacturesUseCase
) : ViewModel() {

    data class HistoriqueFactureState(
        val factures: List<Facture>? = null,
        val error: RootError? = null
    )

    private val _state = MutableStateFlow(HistoriqueFactureState())
    val state = _state.asStateFlow()

    init {
        fetchFactures()
    }

    private fun fetchFactures() {
        viewModelScope.launch {
            when (val result = getFacturesUseCase()) {
                is RequestResult.Success -> {
                    _state.value = HistoriqueFactureState(factures = result.data)
                }
                is RequestResult.Error -> {
                    _state.value = HistoriqueFactureState(error = result.error)
                }
            }
        }
    }
}
