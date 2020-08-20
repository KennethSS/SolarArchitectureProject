package com.solar.architecture.mvp.presenter

import com.solar.architecture.mvp.contract.FoodContract
import com.solar.domain.repository.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FoodPresenter (
    private val foodRepository: FoodRepository) : FoodContract.Presenter {
    lateinit var view: FoodContract.View

    private val disposable = CompositeDisposable()

    override fun start() {
        //foodView.initLayout()
    }

    override fun initDatabase() {

    }

    override fun loadSampleMessage() {
        val dis = foodRepository.getFeedList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.loadMessage(it.first().name)
                },
                {

                }
            )
        disposable.add(dis)
    }

    override fun attach(view: FoodContract.View) {
        this.view = view
    }
}
