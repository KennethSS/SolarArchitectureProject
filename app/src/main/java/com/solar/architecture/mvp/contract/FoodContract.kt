package com.solar.architecture.mvp.contract

interface FoodContract {
    interface View: BaseView<Presenter> {
        fun initViewPager()
        fun loadMessage(str: String)
    }

    interface Presenter: BasePresenter {
        fun initDatabase()
        fun loadSampleMessage()
        fun attach(view: View)
    }
}