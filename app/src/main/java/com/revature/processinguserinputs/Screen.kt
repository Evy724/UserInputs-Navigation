package com.revature.processinguserinputs

sealed class Screen(val route:String) {

    object LoginScreen:Screen("Login_Screen")
    object ProfileScreen:Screen("Profile_Screen")
    object PostScreen:Screen("Post_Screen")
}