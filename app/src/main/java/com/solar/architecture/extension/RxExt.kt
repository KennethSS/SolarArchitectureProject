package com.solar.architecture.extension

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.solar.architecture.NetworkState
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

operator fun CompositeDisposable.plusAssign(d: Disposable) {
    this.add(d)
}

fun <T> Single<T>.base() =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.base() =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.base() =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun Completable.base() =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.observable(state: MutableLiveData<NetworkState<T>>): Disposable =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { state.postValue(NetworkState.Loading) }
        .subscribe(
            {
                Log.d("NetworkState.Success", "NetworkState.Success")
                state.postValue(NetworkState.Success(it))
            },
            { state.postValue(NetworkState.Error(it)) }
        )

fun <T> Single<T>.single(state: MutableLiveData<NetworkState<T>>) =
    subscribeOn(Schedulers.io())
        .doAfterTerminate { state.postValue(NetworkState.Init) }
        .doOnSubscribe { state.postValue(NetworkState.Loading) }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { state.postValue(NetworkState.Success(it)) },
            { state.postValue(NetworkState.Error(it))  }
        )
