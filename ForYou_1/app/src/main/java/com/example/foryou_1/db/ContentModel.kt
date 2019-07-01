package com.example.samplearchitectureforyou

import android.os.Parcelable
import com.example.samplearchitectureforyou.extraclasses.ContentData
import com.example.samplearchitectureforyou.extraclasses.Fields
import com.example.samplearchitectureforyou.extraclasses.Response
import com.example.samplearchitectureforyou.extraclasses.Stats
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ContentModel(
 private val id: String,
 val title: String,//save this
 val title_alignment: String,
 val description: String,
private val banner_url: String,
 val type: String,
private val thumbnail_url: String,
private val name: String,
private val followers: String,
                         var data: ContentData,//save this
private val stats: Stats,
private val tags: List<String>,
 val media_id: String,//save this
private val isTypeOf: Boolean,
private val audio_id: String,
private val created_by: String,
private val created_on: String,
private val embedded: Boolean,
private val enabled: Boolean,
private val external_id: String,
private val last_modified_by: String,
private val last_modified_on: String,
private val media_alignment: String,
private val media_position: String,
private val media_shape: String,
private val media_size: String,
private val points: Int?= null,
private val sensitive: Boolean,
private val show_audio: Boolean,
private val show_description: Boolean,
private val show_media: Boolean,
private val show_title: Boolean,
private val status: String,
 var count: String,
private val content: ContentModel,
private val content_id: String,
private val badge_url: String,
private val language_no: Int?= null,
private val code: String,
private val featured: Boolean,
private val user_uploaded: Boolean,
private val owner_id: String,
private val response: Response,
private val answered: Boolean,
//private val submitted_answer: Objects,
private val fields: List<Fields>): Parcelable{

}