package com.example.ejercicio1_tema2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejercicio1_tema2.R

@Composable
fun Screen1(){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        val itemList = listOf(
            Asignatura("Historia", R.drawable.history),
            Asignatura("Matematicas", R.drawable.math),
        )
        LazyColumn (modifier = Modifier.padding(horizontal = 15.dp).fillMaxWidth())
        {
            repeat(5) {
                items (itemList)
                { asign ->
                    Column(Modifier.fillMaxWidth()){
                        Text(asign.asignatura,
                            Modifier.align(Alignment.CenterHorizontally))
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .clip(shape = RoundedCornerShape(20.dp))
                        ){
                            Image(
                                painter = painterResource(asign.imageId),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                            )
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}
data class Asignatura(val asignatura: String, val imageId: Int)
