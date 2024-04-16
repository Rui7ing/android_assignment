package com.thoughtworks.androidtrain.androidassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thoughtworks.androidtrain.androidassignment.ui.AppContent
import com.thoughtworks.androidtrain.androidassignment.ui.theme.AndroidAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAssignmentTheme {
                AppContent(this)
            }
        }
    }
}
