package com.revature.processinguserinputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.revature.processinguserinputs.ui.theme.ProcessingUserInputsTheme
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProcessingUserInputsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
                    ) {
                        //Login Screen
                        composable(Screen.LoginScreen.route) {
                            LoginScreen(navController)
                        }
                        //Profile Screen
                        composable(route = Screen.ProfileScreen.route
                                + "/{name}/{userId}/{created}",
                            arguments = listOf(
                                navArgument("name") {
                                    type = NavType.StringType
                                },
                                navArgument("userId") {
                                    type = NavType.StringType
                                },
                                navArgument("created") {
                                    type = NavType.LongType
                                }
                            )
                        ) {
                                val name = it.arguments?.getString("name")
                                val userId = it.arguments?.getString("userId")
                                val created = it.arguments?.getLong("created")
                            if (name != null) {
                                if (userId != null) {
                                    if (created != null) {
                                        ProfileScreen(
                                            navController = navController,
                                            name = name,
                                            userId = userId,
                                            created = created
                                        )
                                    }
                                }
                            }
                        }
                        //Post Screen
                        composable(route = Screen.PostScreen.route
                                + "/{showPost}",
                            arguments = listOf(
                                navArgument("showPost") {
                                    type = NavType.BoolType
                                    defaultValue = false
                                }
                            )
                        ) {
                            val showPostNew = it.arguments?.getBoolean("showPost")
                            if (showPostNew != null) {
                                PostScreen(showPostNew)
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun LoginScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "Login Screen")
        Button(onClick = {
            navController.navigate(Screen.ProfileScreen.route
                    + "/Evan/1738/031522")
        }) {
            Text(text = "To Profile Screen")
        }
    }
}
@Composable
fun ProfileScreen(navController: NavController, name: String, userId: String, created:Long) {
    //Text- Data from Login Screen
    //Button to go to Profile Page
    val user = rememberSaveable {
        User(
            name = name,
            id = userId,
            created = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(created),
                ZoneId.systemDefault()
            )
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "Profile Screen :$user", textAlign = TextAlign.Center)
        Button(onClick = {
            navController.navigate(Screen.PostScreen.route + "/true")
        }) {
            Text(text = "To Post Screen")
        }
    }
}
@Composable
fun PostScreen(showPost:Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "Post Screen $showPost")
    }
}