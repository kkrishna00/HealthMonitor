package com.stringsattached.healthmonitor.ui.bmi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.stringsattached.healthmonitor.R

class BMIFragment : Fragment(R.layout.fragment_bmi) {

    companion object {
        fun newInstance() = BMIFragment()
    }

    private lateinit var viewModel: BMIViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bmi, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[BMIViewModel::class.java]
        // TODO: Use the ViewModel
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //
                parentFragmentManager.popBackStackImmediate()
            }
        })
    }


}