package com.example.recyclerviewkotlin.data

import androidx.annotation.DrawableRes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flower(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String
) : Parcelable