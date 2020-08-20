package com.solar.architecture.mvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.solar.architecture.mvp.contract.FoodContract

class MvpActivity : AppCompatActivity(), FoodContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
    }

    override fun showFood() {

    }

    override fun showToast() {
        Toast.makeText(this, "Hi Multi Universe", Toast.LENGTH_SHORT).show()
    }
}