package com.stringsattached.healthmonitor.ui.healthMonitor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stringsattached.healthmonitor.adapters.BaseRvAdapter
import com.stringsattached.healthmonitor.adapters.ViewHolderFactoryImpl
import com.stringsattached.healthmonitor.databinding.FragmentHealthMonitorBinding
import com.stringsattached.healthmonitor.`interface`.WidgetCallBack
import com.stringsattached.healthmonitor.model.HealthMonitorActionsWidgets

class HealthMonitorFragment : Fragment(), WidgetCallBack {

    private var _binding: FragmentHealthMonitorBinding? = null

    private val mAdapter by lazy {
        BaseRvAdapter(factory = ViewHolderFactoryImpl(), widgetCallBack = this)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var healthMonitorViewModel: HealthMonitorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        healthMonitorViewModel =
            ViewModelProvider(this)[HealthMonitorViewModel::class.java]

        _binding = FragmentHealthMonitorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding.recyclerview.adapter == null) {
            binding.recyclerview.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mAdapter
            }
            mAdapter.updateRV(
                data = listOf(
                    HealthMonitorActionsWidgets(
                        title = "BMI"
                    )
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClickedAction() {

    }
}