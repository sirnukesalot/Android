package com.example.aviatickets.model.service;


import retrofit2.http.GET
import retrofit2.Call


interface OfferService {
    @GET("offer_list")
    fun fetchOfferList(): Call<OfferAPIresponse>
}
