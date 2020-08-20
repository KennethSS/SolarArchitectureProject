package com.solar.architecture.mvp.contract

interface FoodContract {
    interface View {
        fun showFood()
        fun showToast()
    }

    interface Presenter {
        fun setView(view: View)
        fun showFood()
        fun showMessage()
    }
}