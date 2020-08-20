package com.solar.architecture.mvp.presenter

import com.solar.architecture.mvp.contract.FoodContract

class FoodPresenter(private val foodView: FoodContract.View) : FoodContract.Presenter {
    override fun start() {
        foodView.initLayout()
    }

    override fun initDatabase() {

    }
}