package com.mif.wearcfnotifierapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.mif.wearcfnotifierapp.presentation.view.WearCFNotifierApp
import com.mif.wearcfnotifierapp.presentation.viewmodel.ContestItemViewModel

class WearCFNotifierBaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)
        val contextLiveDataViewModel = ViewModelProvider(this).get(ContestItemViewModel::class.java)
        setContent {
            WearCFNotifierApp(contextLiveDataViewModel)
        }
    }
}
