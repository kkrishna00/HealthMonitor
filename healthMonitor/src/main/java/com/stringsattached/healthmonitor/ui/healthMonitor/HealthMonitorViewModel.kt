package com.stringsattached.healthmonitor.ui.healthMonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stringsattached.healthmonitor.model.BaseDataModel
import com.stringsattached.healthmonitor.model.HealthMonitorActionsWidgets

class HealthMonitorViewModel : ViewModel() {

    private val _rvData = MutableLiveData<List<BaseDataModel>>().apply {
        value = listOf(
            HealthMonitorActionsWidgets(
                title = "BMI - BODY MASS INDEX"
            ),
            HealthMonitorActionsWidgets(
                title = "PERIODS TRACKER - GUARD ON"
            )
        )
    }

    val rvData: LiveData<List<BaseDataModel>> = _rvData
}