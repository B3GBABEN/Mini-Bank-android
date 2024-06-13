// FactureViewModel.kt
package com.b3g.fawri.minibank.presentation.screens.factures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Facture
import com.b3g.fawri.minibank.domain.usecases.GetFacturesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactureViewModel @Inject constructor(
    private val getFacturesUseCase: GetFacturesUseCase
) : ViewModel() {

    data class FactureViewModelState(
        val factures: List<Facture>? = null,
        val error: RootError? = null
    )

    private val _state = MutableStateFlow(FactureViewModelState())
    val state = _state.asStateFlow()

    init {
        fetchFactures()
    }

    private fun fetchFactures() {
        viewModelScope.launch {
            when (val result = getFacturesUseCase()) {
                is RequestResult.Success -> {
                    _state.value = FactureViewModelState(factures = result.data)

                }
                is RequestResult.Error -> showErrorWith(result.error)
            }
        }
    }

    private fun showErrorWith(error: RootError?) {
        _state.value = FactureViewModelState(error = error)
    }
}
