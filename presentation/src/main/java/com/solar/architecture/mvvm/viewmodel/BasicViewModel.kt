package com.solar.architecture.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solar.architecture.mvvm.model.MvvmModel
import com.solar.domain.repository.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BasicViewModel(
    private val foodRepository: FoodRepository
) : BaseViewModel() {

    private val _title: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val title: LiveData<String> = _title

    fun getSampleText() {
        _title.postValue(MvvmModel().getSampleText())
    }

    fun getSample() {
        //_title.postValue("kwe")
        disposable += foodRepository.getFeedList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("BasicViewModel","listsize" + it.size)
                    _title.postValue(it.first().name)
                },
                {
                    Log.d("BasicViewModel",it.message)
                }
            )

    }
}