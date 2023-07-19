package com.stringsattached.healthmonitor.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HealthMonitorActionsHandlerScreenData(
    private val pageType: String
) : Parcelable