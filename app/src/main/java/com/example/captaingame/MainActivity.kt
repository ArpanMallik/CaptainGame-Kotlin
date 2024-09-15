package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                    captainGame()
                }
            }
        }



    }

@Preview
@Composable
fun captainGame()
{
    val treasureFound= remember{ mutableStateOf(0)}
    val directionFound= remember{ mutableStateOf("North")}
    val stromorTreasure=remember{ mutableStateOf("") }
     Column(
         modifier = Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Text(text = "Treasure Found!: ${treasureFound.value}")
         Spacer(modifier = Modifier.height(16.dp))
         Text(text = "Current Direction : ${directionFound.value}")
         Text(text ="${stromorTreasure.value}")
         Button(onClick = {
             directionFound.value = "East"
             if(Random.nextBoolean()) {
                 treasureFound.value += 1
                 stromorTreasure.value = "we found a treasure"
             } else {
                 stromorTreasure.value="Storm Ahead"
             }
         }) {
              Text("Sail East")
         }
         Button(onClick = {
             directionFound.value = "West"
             if(Random.nextBoolean()){
                 treasureFound.value +=1
                 stromorTreasure.value="we found a treasure"
             }
         }) {
             Text("Sail West")
         }

         Button(onClick = {
             directionFound.value="North"
             if (Random.nextBoolean()){
                 treasureFound.value +=1
                 stromorTreasure.value="we found a treasure"

             }else {
                 stromorTreasure.value="Storm Ahead!!!"
             }
         }) {
             Text("Sail North")
         }

         Button(onClick = {
             directionFound.value = "South"
             if(Random.nextBoolean()){
                 treasureFound.value += 1
                 stromorTreasure.value="we found a treasure"
             }else {
                 stromorTreasure.value="Storm Ahead"
             }
                            }) {
             Text("Sail South")

         }

     }
        }


