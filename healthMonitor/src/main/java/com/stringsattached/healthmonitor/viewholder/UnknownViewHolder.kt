package com.stringsattached.healthmonitor.viewholder

import androidx.viewbinding.ViewBinding
import com.stringsattached.healthmonitor.`interface`.WidgetCallBack
import com.stringsattached.healthmonitor.model.BaseDataModel

class UnknownViewHolder(view: ViewBinding) : BaseViewHolder<BaseDataModel>(view.root) {
    override fun bind(data: BaseDataModel, widgetCallBack: WidgetCallBack) {
        //no-op
    }
}
