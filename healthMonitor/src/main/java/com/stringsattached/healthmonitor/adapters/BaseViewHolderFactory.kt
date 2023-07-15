package com.stringsattached.healthmonitor.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.stringsattached.healthmonitor.R
import com.stringsattached.healthmonitor.databinding.HealthMonitorWidgetsActionsLayoutBinding
import com.stringsattached.healthmonitor.databinding.UnknownLayoutBinding
import com.stringsattached.healthmonitor.model.BaseDataModel
import com.stringsattached.healthmonitor.model.HealthMonitorActionsWidgets
import com.stringsattached.healthmonitor.viewholder.BaseViewHolder
import com.stringsattached.healthmonitor.viewholder.HealthMonitorActionsWidgetsVH
import com.stringsattached.healthmonitor.viewholder.UnknownViewHolder

class ViewHolderFactoryImpl {

    companion object {
        private val HEALTH_MONITOR_ACTIONS = R.layout.health_monitor_widgets_actions_layout
        private val Unknown_LayoutBinding = R.layout.unknown_layout
    }

    fun type(item: BaseDataModel): Int = when (item) {
        is HealthMonitorActionsWidgets -> HEALTH_MONITOR_ACTIONS
        else -> {
            Unknown_LayoutBinding
        }
    }

    fun createViewHolder(
        viewType: Int,
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<BaseDataModel> {
        val viewLayout = layoutInflater.inflate(viewType, parent, false)
        return when (viewType) {
            HEALTH_MONITOR_ACTIONS -> HealthMonitorActionsWidgetsVH(
                HealthMonitorWidgetsActionsLayoutBinding.bind(
                    viewLayout
                )
            ) as BaseViewHolder<BaseDataModel>

            else -> UnknownViewHolder(UnknownLayoutBinding.bind(viewLayout))
        }
    }
}