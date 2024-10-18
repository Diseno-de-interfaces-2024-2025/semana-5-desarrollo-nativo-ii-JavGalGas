package com.example.ejercicio1_tema2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                            title = { Text("Título") },
                            navigationIcon = {
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                ){}
                            },
                            actions = {
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                ){}
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                ){}
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
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                    .clickable {
                                        navController.navigate("screen1")
                                    }
                                ){}
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                    .clickable {
                                        navController.navigate("screen2")
                                    }
                                ){}
                                Box(Modifier
                                    .clip(shape = CircleShape)
                                    .height(35.dp)
                                    .width(35.dp)
                                    .background(Color.Black)
                                    .clickable {
                                        navController.navigate("screen3")
                                    }
                                ){}
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