package com.example.app.ui.nav

sealed class Screens(val route: String) {
    object Dashboard : Screens("dashboard")
    object Login : Screens("login")
    object Register : Screens("register")
    object DashBoardNavigation : Screens("dashboardNavigation")
    object LoginNavigation : Screens("loginNavigation")

}