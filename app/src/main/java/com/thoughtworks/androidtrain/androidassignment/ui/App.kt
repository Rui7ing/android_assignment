package com.thoughtworks.androidtrain.androidassignment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.BottomNavigationBar
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.NavigationActions
import com.thoughtworks.androidtrain.androidassignment.ui.navigation.Route


@Composable
fun AppContent() {

    val navController = rememberNavController()
    val navigationActions = remember(navController) { NavigationActions(navController) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: Route.CHAT
    Column {
        AppNavHost(
            navController = navController,
            modifier = Modifier.weight(1f),
        )
        BottomNavigationBar(
            selectedDestination = selectedDestination,
            navigateToTopLevelDestination = navigationActions::navigateTo
        )
    }
}


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.DISCOVER,
    ) {
        composable(Route.DISCOVER) {
            Text(text = "discover")
        }
        composable(Route.CHAT) {
            // chat screen
        }
        composable(Route.CONTACTS) {
            // contact screen
        }
        composable(Route.ME) {
            // profile screen
        }
    }
}