package com.solar.architecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.solar.architecture.dagger.Dagger2Application
import com.solar.architecture.dagger.component.DaggerActivityComponent
import com.solar.architecture.db.room.RoomActivity
import com.solar.architecture.mvp.view.MvpActivity
import com.solar.architecture.mvvm.view.MvvmActivity
import com.solar.architecture.mvvm.viewmodel.BasicViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mvvm.setOnClickListener { startActivity(Intent(this, MvvmActivity::class.java)) }
        mvp.setOnClickListener { startActivity(Intent(this, MvpActivity::class.java)) }
        room.setOnClickListener { startActivity(Intent(this, RoomActivity::class.java)) }
    }
}