package com.example.samplearchitectureforyou.extraclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Response: Parcelable {
    private var correct: Boolean = false
    private var type: String? = null
    private var points: Int = 0
    private var progress: Int = 0
    private var status: String? = null
    private var completed_on: String? = null
    private var choice: Any? = null
    private var choices: Any? = null
    private var comment: String? = null

    fun isCorrect(): Boolean {
        return correct
    }

    fun setCorrect(correct: Boolean) {
        this.correct = correct
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getPoints(): Int {
        return points
    }

    fun setPoints(points: Int) {
        this.points = points
    }

    fun getProgress(): Int {
        return progress
    }

    fun setProgress(progress: Int) {
        this.progress = progress
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getCompleted_on(): String? {
        return completed_on
    }

    fun setCompleted_on(completed_on: String) {
        this.completed_on = completed_on
    }

    fun getChoice(): Any? {
        return choice
    }

    fun setChoice(choice: Any) {
        this.choice = choice
    }

    fun getComment(): String? {
        return comment
    }

    fun setComment(comment: String) {
        this.comment = comment
    }

    fun getChoices(): Any? {
        return choices
    }

    fun setChoices(choices: Any) {
        this.choices = choices
    }
}