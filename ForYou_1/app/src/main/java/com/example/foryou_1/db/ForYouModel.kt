package com.example.foryou_1

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.foryou_1.db.AssignmentModelX
import com.example.samplearchitectureforyou.ContentModel
import com.example.samplearchitectureforyou.db.AssignmentModelListTypeConverter
import com.example.samplearchitectureforyou.db.ContentModelListTypeConverter
import com.example.samplearchitectureforyou.db.ContentModelTypeConverter


/*
* represents response of API call: /api/users/me/foryou
* */
@Entity
@TypeConverters(AssignmentModelListTypeConverter::class, ContentModelListTypeConverter::class, ContentModelTypeConverter::class)
data class ForYouModel(
     @PrimaryKey
     @NonNull
     var uid: String,
     val welcome_message: String?,
     val todo: List<AssignmentModelX>,
     val recommendations: List<AssignmentModelX>,
     val did_you_know: ContentModel?,
     val featured: List<ContentModel>,
     val most_popular: List<ContentModel>,
     val new_noteworty: List<ContentModel>,
     val questions_count: Int?,
     val announcements_count: Int?,
     val questions: List<AssignmentModelX>,
     val public_announcements: List<ContentModel>,
     val announcements: List<AssignmentModelX>,
     val boards: List<AssignmentModelX>,
     val layerType: String?)