package com.solar.architecture.mvp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.solar.architecture.R
import com.solar.architecture.dagger.Dagger2Application
import com.solar.architecture.dagger.component.DaggerActivityComponent
import com.solar.architecture.mvp.contract.FoodContract
import kotlinx.android.synthetic.main.activity_mvp.*
import javax.inject.Inject

class MvpActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        val component = DaggerActivityComponent.builder()
            .appComponent(Dagger2Application.appComponent)
            .build()

        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter.attach(this)
        presenter.start()


        button.setOnClickListener {
            presenter.loadSampleMessage()
        }
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

    override fun getContext(): Context = this
    override fun showError(error: String) {}

    override fun loadMessage(str: String) {
        button.text = str
    }

    override fun initViewPager() {
        view_pager.adapter = object: PagerAdapter() {
            override fun isViewFromObject(view: View, `object`: Any): Boolean = true
            override fun getCount(): Int = 3
        }
    }
}