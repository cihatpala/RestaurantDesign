package com.cihat.egitim.composerestaurant.models

import com.google.gson.annotations.SerializedName

data class RestaurantModel(
    @SerializedName(value = "name")
    val name: String,
    val rate: Int,
    val recommendedTag: Boolean,
    val image: String,
    val stock: Int,
)
