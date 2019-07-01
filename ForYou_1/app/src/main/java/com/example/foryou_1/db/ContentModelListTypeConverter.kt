package com.example.samplearchitectureforyou.db

import androidx.room.TypeConverter
import com.example.samplearchitectureforyou.ContentModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ContentModelListTypeConverter {
    private val gson: Gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<ContentModel>? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ContentModel>>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(listObject: List<ContentModel>?): String? {
        if (listObject == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ContentModel>>() {

        }.type
        return gson.toJson(listObject, type)

    }
}