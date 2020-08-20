package com.solar.architecture.mvp.view

interface BaseView<T> {
    var presenter: T

    fun initLayout()
}