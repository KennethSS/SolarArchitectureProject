package com.solar.architecture.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.solar.architecture.R
import com.solar.architecture.dagger.Dagger2Application
import com.solar.architecture.dagger.component.DaggerActivityComponent
import com.solar.architecture.databinding.ActivityMvvmBinding
import com.solar.architecture.mvvm.viewmodel.BasicViewModel
import javax.inject.Inject

class MvvmActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: BasicViewModel

    lateinit var bind: ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val component = DaggerActivityComponent.builder()
            .appComponent(Dagger2Application.appComponent)
            .build()

        component.inject(this)
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        viewModel.title.observe(this, Observer {
            bind.text = it
        })
        viewModel.getSample()
    }
}