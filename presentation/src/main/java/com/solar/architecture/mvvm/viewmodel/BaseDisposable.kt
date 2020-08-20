package com.solar.architecture.mvvm.viewmodel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseDisposable {
    private val disposable = CompositeDisposable()

    operator fun plusAssign(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    operator fun minusAssign(disposable: Disposable) {
        this.disposable.remove(disposable)
    }

    fun clear() {
        disposable.clear()
    }
}