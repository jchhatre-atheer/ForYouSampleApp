package com.example.samplearchitectureforyou.db

import androidx.room.TypeConverter
import com.example.samplearchitectureforyou.ContentModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ContentModelTypeConverter {
    private val gson: Gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToContentModel(data: String?): ContentModel? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<ContentModel>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun contentModelToString(data: ContentModel?): String? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<ContentModel>() {

        }.type
        return gson.toJson(data, type)

    }
}