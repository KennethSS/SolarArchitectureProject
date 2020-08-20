package com.solar.architecture.mvp.contract

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.solar.domain.model.Food

interface FoodContract {
    interface View: BaseView<Presenter> {
        fun initViewPager()
        fun loadMessage(str: String)
        fun submitFoodList(foods: List<Food>)
    }

    interface Presenter: BasePresenter {
        fun initObserve(lifecycle: LifecycleOwner)
        fun initDatabase()
        fun loadSampleMessage()
        fun attach(view: View, viewLifeCycle: Lifecycle)
    }
}