package com.b3g.fawri.minibank.ui.Comptes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {
    private val _accountBalance = MutableLiveData<Double>()
    val accountBalance: LiveData<Double> get() = _accountBalance

    fun updateBalance(newBalance: Double) {
        _accountBalance.value = newBalance
    }
}
