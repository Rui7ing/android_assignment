package com.thoughtworks.androidtrain.androidassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.BottomNavigationBar
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.NavigationActions
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.Route
import com.thoughtworks.androidtrain.androidassignment.ui.theme.AndroidAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAssignmentTheme {
                val navController = rememberNavController()
                val navigationActions = remember(navController) { NavigationActions(navController) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val selectedDestination = navBackStackEntry?.destination?.route ?: Route.CHAT

                BottomNavigationBar(
                    selectedDestination = selectedDestination,
                    navigateToTopLevelDestination = navigationActions::navigateTo
                )
            }
        }
    }
}
