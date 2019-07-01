package com.example.foryou_1.db

data class Data(
    val `public`: Boolean,
    val available_from: String,
    val content: String,
    val content_color: String,
    val discontinue_from: String,
    val is_public: Boolean,
    val show_content: Boolean,
    val show_title: Boolean,
    val title_color: String,
    val type: String
)