package com.example.samplearchitectureforyou

import com.example.samplearchitectureforyou.extraclasses.DeviceProperties
import com.example.samplearchitectureforyou.extraclasses.Response

data class AssignmentModel (
 private val created_by: String,
private val created_on: String,
private val last_modified_by: String,
//private val last_modified_on: String,
//private val id: String,
//private val user_id: String,
//private val user_info: String,
//private val exp_source: String,
//private val exp_source_id: String,
//private val assigned_on: String,
//private val due_on: String,
//private val started_on: String,
//private val completed_on: String,
//private val status: String,
//private val progress: Int,
 //val completion_id: String,
 //val response_id: String,
 //val time_spent: Long,
// val points: Int,
 //val pass: Boolean, val `object`: ContentModel,
 val device_properties: DeviceProperties,
 val count: String,
private val item_count: String,
private val name: String,
private val description: String,
private val acquired_on: String,
 val response: Response,
 val assigned: Boolean)