package com.stringsattached.healthmonitor.ui.healthMonitor.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stringsattached.healthmonitor.databinding.ActivityHealthMonitorActionsHandlerBinding
import com.stringsattached.healthmonitor.model.HealthMonitorActionsHandlerScreenData

class HealthMonitorActionsHandlerActivity : AppCompatActivity() {


    private lateinit var screenData: HealthMonitorActionsHandlerScreenData
    private lateinit var binding: ActivityHealthMonitorActionsHandlerBinding

    companion object {
        private const val SCREEN_DATA = "screenData"

        fun startHealthMonitorActionsHandlerActivity(
            screenData: HealthMonitorActionsHandlerScreenData,
            context: Context
        ) {
            val intent = Intent(context, HealthMonitorActionsHandlerActivity::class.java)
            intent.putExtra(SCREEN_DATA, screenData)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthMonitorActionsHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readBundleData()
    }

    private fun readBundleData() {
        screenData = intent.getParcelableExtra(SCREEN_DATA)!!
    }

}