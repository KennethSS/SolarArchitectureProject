package com.solar.architecture.mvp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.solar.architecture.R
import com.solar.architecture.mvp.contract.FoodContract
import com.solar.architecture.mvp.presenter.FoodPresenter
import kotlinx.android.synthetic.main.activity_mvp.*

class MvpActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter = FoodPresenter(this)
        presenter.start()
    }

    override fun initLayout() {
        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) { }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    override fun initViewPager() {
        view_pager.adapter = object: PagerAdapter() {
            override fun isViewFromObject(view: View, `object`: Any): Boolean = true
            override fun getCount(): Int = 3
        }
    }
}