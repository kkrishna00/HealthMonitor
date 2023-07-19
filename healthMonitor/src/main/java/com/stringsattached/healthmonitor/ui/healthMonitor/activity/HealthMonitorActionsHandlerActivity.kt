package com.stringsattached.healthmonitor.ui.healthMonitor.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stringsattached.healthmonitor.R
import com.stringsattached.healthmonitor.model.HealthMonitorActionsHandlerScreenData

class HealthMonitorActionsHandlerActivity : AppCompatActivity() {

    companion object {
        private lateinit var screenData: HealthMonitorActionsHandlerScreenData
        private const val SCREEN_DATA = "screenData"

        fun startHealthMonitorActionsHandlerActivity(
            screenData: HealthMonitorActionsHandlerScreenData,
            context: Context
        ) {
            val intent = Intent(context, HealthMonitorActionsHandlerActivity::class.java)
            val bundle = Bundle().apply {
                putParcelable(SCREEN_DATA, screenData)
            }
            context.startActivity(intent, bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_monitor_actions_handler)

        readBundleData()
    }

    private fun readBundleData() {
        screenData = intent.getParcelableExtra(SCREEN_DATA)!!
    }

}