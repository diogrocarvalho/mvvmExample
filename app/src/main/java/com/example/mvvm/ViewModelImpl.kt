package com.example.mvvm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class Payment {
    val transitionType = ObservableField("---")
}

class ViewModelExample : ViewModel() {
    val payment = Payment()

    fun setPayment(type: String) {
        payment.transitionType.set(type)
    }
}

