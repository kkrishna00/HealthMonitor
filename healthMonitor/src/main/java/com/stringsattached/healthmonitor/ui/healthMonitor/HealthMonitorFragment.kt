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
import com.stringsattached.healthmonitor.model.BaseAction
import com.stringsattached.healthmonitor.model.HealthMonitorBMIClickAction

class HealthMonitorFragment : Fragment(), WidgetCallBack {

    private var _binding: FragmentHealthMonitorBinding? = null

    private val mAdapter by lazy {
        BaseRvAdapter(factory = ViewHolderFactoryImpl(), widgetCallBack = this)
    }

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
        setupRv()
        observerViewModel()
    }

    private fun observerViewModel() {
        healthMonitorViewModel.rvData.observe(viewLifecycleOwner) { data ->
            mAdapter.updateRV(data = data)
        }
    }

    private fun setupRv() {
        if (binding.recyclerview.adapter == null) {
            binding.recyclerview.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClickedAction(action: BaseAction) {
        when (action) {
            is HealthMonitorBMIClickAction -> {
                // to -do
            }
        }
    }
}