package com.example.wikipediasample.data

data class ItemPost(
    val urlImage: String,
    val textTitle: String,
    val textSubtitle: String,
    val textDescription: String,

    // For trend fragment

    val isTrend: Boolean,
    val insight: String
)