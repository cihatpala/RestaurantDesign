package com.cihat.egitim.composerestaurant.service

import com.cihat.egitim.composerestaurant.models.RestaurantModel
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantAPI {
    //base: https://raw.githubusercontent.com/
    //cihatpala/RestaurantDesign/refs/heads/master/restaurants.json
    @GET("cihatpala/RestaurantDesign/refs/heads/master/restaurants.json")
    fun getData(): Call<List<RestaurantModel>>
}