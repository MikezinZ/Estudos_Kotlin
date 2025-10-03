package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
               ) {
                   BusinessCard ("Miguel Melo", "Desenvolvedor", "(81) 99999-9999", "@MiguelDev","Miguelito@teste.com")
               }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, social: String, email: String) {
    Surface (color = Color.LightGray){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.android_logo),
                    contentDescription = null,
                    Modifier.background(color = Color(0xFF073042))
                        .size(150.dp)
                )

                Text(
                    text = name,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp)
                )

                Text(
                    text = title,
                    fontSize = 20.sp,
                    color = Color.Green
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 120.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.square),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = phone
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.phone),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = social
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.email),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = email
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BusinessCard ("Miguel Melo", "Desenvolvedor", "(81) 99999-9999", "@MiguelDev", "Miguelito@teste.com")
    }
}