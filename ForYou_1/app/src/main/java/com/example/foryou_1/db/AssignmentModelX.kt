package com.example.foryou_1.db

import android.os.Parcelable
import com.example.samplearchitectureforyou.ContentModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AssignmentModelX(
    //for now, Any is substituted by String
    val `object`: ContentModel,
    val assigned_on: String,
    val completed_on: String,//Any?,
    val completion_id: String,//Any?,
    val created_by: String,
    val created_on: String,
    val due_on: String,
    val exp_source: String,//Any?,
    val exp_source_id: String,//Any?,
    val from_series: Boolean, //na
    val id: String,
    val last_modified_by: String,
    val last_modified_on: String,
    val note: String,//Any?,//na
    val pass: Boolean,
    val points: Int? = null,
    val progress: Int?= null,
    val required: Boolean,
    val response_id: String,//Any?,
    val started_on: String,//Any?,
    val status: String,
    val time_spent: String,//Any?,
    val user_id: String,
    val user_info: String//Any?
): Parcelable