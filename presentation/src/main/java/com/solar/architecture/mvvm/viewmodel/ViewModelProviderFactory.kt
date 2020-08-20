package com.solar.architecture.mvvm.viewmodel

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import java.util.function.Supplier

class ViewModelProviderFactory<T : ViewModel> constructor(
    private val viewModelClass: Class<T>,
    private val viewModelSupplier: Supplier<T>
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass)) {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                viewModelSupplier.get() as T
            } else {
                TODO("VERSION.SDK_INT < N")
            }
        } else {
            throw IllegalArgumentException("Unknown Class name" + viewModelClass.name)
        }
    }
}