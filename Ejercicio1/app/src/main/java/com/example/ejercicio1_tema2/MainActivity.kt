package com.example.ejercicio1_tema2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio1_tema2.ui.components.Screen1
import com.example.ejercicio1_tema2.ui.components.Screen2
import com.example.ejercicio1_tema2.ui.components.Screen3
import com.example.ejercicio1_tema2.ui.theme.Ejercicio1_Tema2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1_Tema2Theme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFFCDE7B0)
                            ),
                            title = { Text("Asignaturas") },
                            navigationIcon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "favorite",
                                    tint = Color.Black,
                                    modifier = Modifier.size(30.dp)
                                )
                            },
                            actions = {
                                Icon(
                                    imageVector = Icons.Filled.AccountCircle,
                                    contentDescription = "favorite",
                                    tint = Color.DarkGray,
                                    modifier = Modifier.size(48.dp)
                                )
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color(0xFFCDE7B0)
                        )
                        {
                            Row (Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly)
                            {
                                Icon(
                                    painter = painterResource(R.drawable.home),
                                    contentDescription = "favorite",
                                    tint = Color.Black,
                                    modifier = Modifier.size(30.dp)
                                        .clickable {
                                            navController.navigate("screen1")
                                        }
                                )
                                Icon(
                                    painter = painterResource(R.drawable.edit),
                                    contentDescription = "favorite",
                                    tint = Color.Black,
                                    modifier = Modifier.size(25.dp)
                                        .clickable {
                                            navController.navigate("screen2")
                                        }
                                )
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "favorite",
                                    tint = Color.Red,
                                    modifier = Modifier.size(30.dp)
                                        .clickable {
                                            navController.navigate("screen3")
                                        }
                                )
                            }
                        }
                    },

                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyNavControllerCustom(navController,
                        Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun MyNavControllerCustom(navController: NavHostController, modifier: Modifier){

        NavHost(navController = navController, startDestination = "screen1",
            modifier = modifier){
            composable("screen1"){ Screen1() }
            composable("screen2"){ Screen2() }
            composable("screen3"){ Screen3() }
        }
    }
}