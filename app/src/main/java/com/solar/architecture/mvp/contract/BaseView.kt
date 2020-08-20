package com.solar.architecture.mvp.contract

import android.content.Context
import androidx.annotation.StringRes

interface BaseView<T> {
    var presenter: T

    fun initLayout()
    fun getContext(): Context
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
}