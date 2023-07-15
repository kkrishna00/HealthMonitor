package com.stringsattached.healthmonitor.ui.goalsAndActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stringsattached.healthmonitor.databinding.FragmentActivityGoalsBinding

class GoalsAndActivityFragment : Fragment() {

    private var _binding: FragmentActivityGoalsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val goalsAndActivityViewModel =
            ViewModelProvider(this)[GoalsAndActivityViewModel::class.java]

        _binding = FragmentActivityGoalsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.title
        goalsAndActivityViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}