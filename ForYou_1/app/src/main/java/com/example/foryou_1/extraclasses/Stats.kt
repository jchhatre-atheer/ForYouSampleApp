package com.example.samplearchitectureforyou.extraclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stats(  private val pins: Int,
private val reactions: Int,
private val views: Int,
private val followers: Int,
private val contents: Int): Parcelable