package com.example.wikipediasample.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val urlImage: String,
    val textTitle: String,
    val textSubtitle: String,
    val textDescription: String,


    // For trend fragment
    val isTrend: Boolean,
    val insight: String,
    val textWebSite: String

) : Parcelable