package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFFFFFF))
            ){
                Image(
                    painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(30.dp))
                        .fillMaxWidth(1f)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp)
                ){
                    Text(
                        "Menu Makanan",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight(600),
                        color = androidx.compose.ui.graphics.Color.Black)
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(
                        "Harga Rp. 25.000",
                        fontWeight = FontWeight.Bold,
                        color = androidx.compose.ui.graphics.Color.Green,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}