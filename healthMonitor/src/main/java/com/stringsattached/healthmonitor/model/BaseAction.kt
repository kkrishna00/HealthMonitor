package com.stringsattached.healthmonitor.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class BaseAction

@Parcelize
object HealthMonitorBMIClickAction : BaseAction(), Parcelable