package com.solar.architecture.mvvm.viewmodel

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val disposable = BaseDisposable()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}