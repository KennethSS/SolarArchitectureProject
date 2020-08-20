package com.solar.architecture.mvp.presenter

import com.solar.architecture.mvp.contract.FoodContract

class FoodPresenter(private val view: FoodContract.View) : FoodContract.Presenter {
    override fun setView(view: FoodContract.View) {

    }

    override fun showFood() { view.showFood() }
    override fun showMessage() { view.showToast() }
}