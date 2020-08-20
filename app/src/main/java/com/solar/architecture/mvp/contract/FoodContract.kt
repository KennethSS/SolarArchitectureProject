package com.solar.architecture.mvp.contract

import com.solar.architecture.mvp.presenter.BasePresenter
import com.solar.architecture.mvp.view.BaseView

interface FoodContract {
    interface View: BaseView<Presenter> {
        fun initViewPager()
    }

    interface Presenter: BasePresenter {
        fun initDatabase()

    }
}