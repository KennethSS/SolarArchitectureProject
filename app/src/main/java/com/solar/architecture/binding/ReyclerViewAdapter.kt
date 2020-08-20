package com.solar.architecture.binding

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.solar.architecture.R
import com.solar.architecture.mvp.view.FoodViewHolder
import com.solar.domain.model.Food
import kotlinx.android.synthetic.main.recyclerview_item_youtube.view.*

@BindingAdapter("food_list")
fun submitFoodList(recyclerView: RecyclerView, foods: List<Food>?) {
    foods?.let {
        recyclerView.adapter = object: RecyclerView.Adapter<FoodViewHolder>() {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): FoodViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item_youtube, parent, false)
                return FoodViewHolder(view)
            }

            override fun getItemCount(): Int = foods.size
            override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
                Log.d("onBindViewHolder", foods[position].name)

                holder.itemView.let {
                    it.item_youtube_title.text = foods[position].name
                }
            }

        }
    }
}