package com.stringsattached.healthmonitor.ui.goalsAndActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GoalsAndActivityViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "COMING SOON....."
    }
    val text: LiveData<String> = _text
}