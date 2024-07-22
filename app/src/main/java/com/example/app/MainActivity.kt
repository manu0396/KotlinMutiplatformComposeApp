package com.example.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.nav.Screens
import com.example.app.ui.screen.DashboardScreen
import com.example.app.ui.screen.LoginScreen
import com.example.app.ui.screen.RegisterScreen
import com.example.app.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                setUpUI()
            }
        }
    }

    @Composable
    private fun setUpUI() {
        val navController = rememberNavController()
        navController.addOnDestinationChangedListener { ctl, dest, _ ->
            Log.d(
                "com.example.app",
                "NavController OnRouteChange / ${ctl.previousBackStackEntry?.destination?.route} -> ${dest.route}"
            )
        }
        NavHost(
            navController = navController,
            startDestination = Screens.LoginNavigation.route
        ) {
            navigation(
                startDestination = Screens.Login.route,
                route = Screens.LoginNavigation.route
            ) {
                composable(Screens.Login.route) {
                    LoginScreen(viewModel())
                }
                composable(Screens.Register.route) {
                    RegisterScreen(viewModel())
                }
            }
            navigation(
                startDestination = Screens.Dashboard.route,
                route = Screens.DashBoardNavigation.route
            ) {
                composable(Screens.Dashboard.route) {
                    DashboardScreen(viewModel())
                }
            }
        }
    }
}