package com.example.latihan2

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContohRow() {
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .verticalScroll(
                enabled = true,
                state = ScrollState(0)
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(50.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .fillMaxWidth(1f)
        )
        Text(text = "Menu Makanan",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight(600),
            color = Color.Blue,
            modifier = Modifier.padding(top = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(id = R.drawable.rendang),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(100.dp,50.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(1f)
            )
            Text(
                text = "Nasi Ramas Rendang Daging",
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 15.sp
            )
            Text(
                text = "Rp25.000",
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 15.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(id = R.drawable.rendangayam),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(100.dp,50.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(1f)
            )
            Text(
                text = "Nasi Ramas Rendang Ayam",
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 15.sp
            )
            Text(
                text = "Rp22.000",
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 15.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(id = R.drawable.ayambakar),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(100.dp,50.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(1f)
            )
            Text(
                text = "Nasi Ramas Ayam Bakar",
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 15.sp
            )
            Text(
                text = "Rp20.000",
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 15.sp
            )
        }
    }
}
