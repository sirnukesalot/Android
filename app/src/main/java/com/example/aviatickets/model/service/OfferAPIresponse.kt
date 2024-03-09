package com.example.aviatickets.model.service

import com.example.aviatickets.model.entity.Offer

data class OfferAPIresponse(
    val results: List<Offer> = listOf()
)
