package com.example.samplearchitectureforyou.extraclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Fields: Parcelable {
    private var name: String? = null
    private var label: String? = null
    private var description: String? = null
    private var group_name: String? = null
    private var group_label: String? = null
    private var group_description: String? = null
    private var default_value: String? = null
    private var value: String? = null
    private var editable: String? = null
    private var encrypted: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getLabel(): String? {
        return label
    }

    fun setLabel(label: String) {
        this.label = label
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getGroup_name(): String? {
        return group_name
    }

    fun setGroup_name(group_name: String) {
        this.group_name = group_name
    }

    fun getGroup_label(): String? {
        return group_label
    }

    fun setGroup_label(group_label: String) {
        this.group_label = group_label
    }

    fun getGroup_description(): String? {
        return group_description
    }

    fun setGroup_description(group_description: String) {
        this.group_description = group_description
    }

    fun getDefault_value(): String? {
        return default_value
    }

    fun setDefault_value(default_value: String) {
        this.default_value = default_value
    }

    fun getValue(): String? {
        return value
    }

    fun setValue(value: String) {
        this.value = value
    }

    fun getEditable(): String? {
        return editable
    }

    fun setEditable(editable: String) {
        this.editable = editable
    }

    fun getEncrypted(): String? {
        return encrypted
    }

    fun setEncrypted(encrypted: String) {
        this.encrypted = encrypted
    }
}