package com.stringsattached.healthmonitor.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stringsattached.healthmonitor.`interface`.WidgetCallBack
import com.stringsattached.healthmonitor.model.BaseDataModel

abstract class BaseViewHolder<in Model : BaseDataModel>(view: View) :
    RecyclerView.ViewHolder(view) {
    abstract fun bind(data: Model, widgetCallBack: WidgetCallBack)
}