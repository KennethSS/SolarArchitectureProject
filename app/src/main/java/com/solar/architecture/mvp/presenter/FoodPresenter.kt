package com.solar.architecture.mvp.presenter

import androidx.lifecycle.*
import com.solar.architecture.NetworkState
import com.solar.architecture.extension.single
import com.solar.architecture.mvp.contract.FoodContract
import com.solar.domain.model.Food
import com.solar.domain.repository.FoodRepository
import io.reactivex.disposables.CompositeDisposable

class FoodPresenter (
    private val foodRepository: FoodRepository) : FoodContract.Presenter, LifecycleObserver {
    lateinit var view: FoodContract.View

    private val disposable = CompositeDisposable()

    private val _foodListLiveData = MutableLiveData<NetworkState<List<Food>>>()
    val foodListLiveData: LiveData<NetworkState<List<Food>>> = _foodListLiveData

    override fun initObserve(lifecycle: LifecycleOwner) {
        foodListLiveData.observe(lifecycle, Observer {
            when(it) {
                is NetworkState.Success -> {
                    view.submitFoodList(it.item)
                }
                is NetworkState.Error -> {
                    view.showError(it.throwable?.message?:"")
                }
            }
        })
    }

    override fun initDatabase() {

    }

    override fun loadSampleMessage() {
        val dis = foodRepository.getFeedList()
            .single(_foodListLiveData)
        disposable.add(dis)
    }

    override fun attach(view: FoodContract.View, viewLifeCycle: Lifecycle) {
        this.view = view
        viewLifeCycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposable.clear()
    }
}
