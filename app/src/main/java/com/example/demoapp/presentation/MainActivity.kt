package com.example.demoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demoapp.architecture.Router
import com.example.demoapp.presentation.all_names.AllNamesScreen
import com.example.demoapp.presentation.hello_name.HelloNameScreen
import com.example.demoapp.presentation.home.HomeScreen
import com.example.demoapp.presentation.MainDestination.*
import com.example.demoapp.presentation.theme.DemoAppTheme
import com.example.demoapp.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity(), Router<MainDestination> {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoAppTheme {
                navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(
                        route = Screen.Home.route
                    ) {
                        HomeScreen(this@MainActivity)
                    }
                    composable(
                        route = Screen.HelloName.route + "?name={name}",
                        arguments = listOf(navArgument(name = "name") {
                            type = NavType.StringType
                        })
                    ) {
                        HelloNameScreen()
                    }
                    composable(
                        route = Screen.AllNames.route
                    ) {
                        AllNamesScreen()
                    }
                }
            }
        }
    }

    override fun routeTo(destination: MainDestination) {
        when (destination) {
            is NavigateAllNames -> navController.navigate(Screen.AllNames.route)
            is NavigateHelloName -> navController.navigate(
                "${Screen.HelloName.route}?name=${destination.name}"
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoAppTheme {
        Greeting("Android")
    }
}