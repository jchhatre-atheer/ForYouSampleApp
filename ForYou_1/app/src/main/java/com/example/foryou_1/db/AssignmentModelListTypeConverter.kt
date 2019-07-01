package com.example.samplearchitectureforyou.db

import androidx.room.TypeConverter
import com.example.foryou_1.db.AssignmentModelX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AssignmentModelListTypeConverter {
    private val gson: Gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<AssignmentModelX>? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<AssignmentModelX>>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(listObject: List<AssignmentModelX>?): String? {
        if (listObject == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<AssignmentModelX>>() {

        }.type
        return gson.toJson(listObject, type)

    }
}