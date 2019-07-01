package com.example.samplearchitectureforyou.extraclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentData (var type: String,
                        var is_public: Boolean,
                        var content: String,
                        var title_color: String,
                        var content_color: String
                        ): Parcelable