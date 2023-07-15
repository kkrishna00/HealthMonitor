package com.stringsattached.healthmonitor.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface BaseDataModel : Parcelable {
    val type: String
}

@Parcelize
data class HealthMonitorActionsWidgets(
    val title: String,
    override val type: String = TYPE
) : BaseDataModel {
    companion object {
        const val TYPE = "health"
    }
}
