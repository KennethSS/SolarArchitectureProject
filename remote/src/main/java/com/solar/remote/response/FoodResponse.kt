package com.solar.remote.response

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("author")
    val author: Int?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("reaction_count")
    val reaction_count: Int?,
    @SerializedName("feed_images")
    val feed_images: List<String>?
)