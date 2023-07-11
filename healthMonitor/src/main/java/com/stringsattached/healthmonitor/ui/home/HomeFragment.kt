package com.stringsattached.healthmonitor.ui.home

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stringsattached.healthmonitor.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), SensorEventListener {

    companion object {
        const val ERROR = "No sensor detected on this device"
    }

    private var _binding: FragmentHomeBinding? = null

    private var running = false

    private var totalSteps = 0f

    private val binding get() = _binding!!

    private lateinit var sensorManager: SensorManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager =
            getSystemService(requireContext(), SensorManager::class.java) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        running = true
        handleStepSensor()
    }

    private fun handleStepSensor() {

        val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            Toast.makeText(
                requireContext(),
                ERROR,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_STATUS_ACCURACY_HIGH)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSensorChanged(event: SensorEvent?) {


        if (running) {
            //get the number of steps taken by the user.
            totalSteps = event?.values?.getOrNull(index = 0) ?: 0f

            val currentSteps = totalSteps.toInt()

            binding.textHome.text = ("$currentSteps")
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
        // unregister listener
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d("onAccuracyChanged", "Sensor: $sensor; accuracy: $accuracy")
    }
}