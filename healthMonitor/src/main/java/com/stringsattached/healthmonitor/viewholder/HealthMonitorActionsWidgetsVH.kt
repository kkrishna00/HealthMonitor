package com.stringsattached.healthmonitor.viewholder

import androidx.viewbinding.ViewBinding
import com.stringsattached.healthmonitor.databinding.HealthMonitorWidgetsActionsLayoutBinding
import com.stringsattached.healthmonitor.`interface`.WidgetCallBack
import com.stringsattached.healthmonitor.model.HealthMonitorActionsWidgets

class HealthMonitorActionsWidgetsVH(bind: ViewBinding) :
    BaseViewHolder<HealthMonitorActionsWidgets>(bind.root) {

    private val binding = bind as HealthMonitorWidgetsActionsLayoutBinding
    override fun bind(data: HealthMonitorActionsWidgets, widgetCallBack: WidgetCallBack) {
        binding.title.text = data.title
    }

}
