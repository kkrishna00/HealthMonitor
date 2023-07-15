package com.stringsattached.healthmonitor.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stringsattached.healthmonitor.`interface`.WidgetCallBack
import com.stringsattached.healthmonitor.model.BaseDataModel
import com.stringsattached.healthmonitor.viewholder.BaseViewHolder

class BaseRvAdapter(
    private val factory: ViewHolderFactoryImpl,
    private val widgetCallBack: WidgetCallBack
) : RecyclerView.Adapter<BaseViewHolder<BaseDataModel>>() {


    private var listingItems = emptyList<BaseDataModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateRV(data: List<BaseDataModel>) {
        listingItems = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseDataModel> {
        return factory.createViewHolder(
            viewType = viewType,
            parent = parent,
            layoutInflater = LayoutInflater.from(parent.context)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseDataModel>, position: Int) {
        holder.bind(listingItems[position], widgetCallBack)
    }

    override fun getItemCount(): Int = listingItems.size

    override fun getItemViewType(position: Int): Int {
        return factory.type(listingItems[position])
    }
}