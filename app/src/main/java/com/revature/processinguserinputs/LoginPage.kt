//package com.revature.processinguserinputs
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.revature.processinguserinputs.ui.theme.ProcessingUserInputsTheme
//
//class LoginPage : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ProcessingUserInputsTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Login()
//                }
//            }
//        }
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun Login() {
//    val context = LocalContext.current
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp)
//    ) {
//        Text(
//            text = "Log in",
//            style = TextStyle(
//                fontWeight = FontWeight.Bold
//            )
//        )
//        Spacer(modifier = Modifier.padding(20.dp))
//
//        var localUsername by rememberSaveable { mutableStateOf("") }
//        TextField(
//            value = localUsername,
//            onValueChange = {localUsername = it},
//            label = { Text(text = "Username: ") }
//        )
//        var localPassword by rememberSaveable { mutableStateOf("") }
//        Spacer(modifier = Modifier.padding(5.dp))
//
//        TextField(
//            value = localPassword,
//            onValueChange = { localPassword = it },
//            label = { Text(text = "Password: ") }
//        )
//        Spacer(modifier = Modifier.padding(10.dp))
//
//        var status by rememberSaveable { mutableStateOf("") }
//
//        Button(
//            onClick = { status = verifyLoginInfo(
//                localUsername = localUsername,
//                localPassword = localPassword )
//                context.startActivity(Intent(context, ProfilePage::class.java))
//                      },
//            modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .height(50.dp)
//        ) {
//            Text(text = "Log in")
//        }
//
//        Toast.makeText(context, status, Toast.LENGTH_SHORT).show()
//
//    }
//}
//
//fun verifyLoginInfo(localUsername:String, localPassword:String): String {
//    val result: String
//    val username = "evan"
//    val password = "jones"
//
//
//    result = if(localUsername == username && localPassword == password) {
//        "Login Successful"
//    } else {
//        "Login Failed"
//    }
//    return result
//}