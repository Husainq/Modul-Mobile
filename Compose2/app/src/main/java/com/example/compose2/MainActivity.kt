package com.example.compose2

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose2.ui.theme.Compose2Theme

class MainActivity : ComponentActivity() {
    override fun OnCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            ContohRow()
        }
    }
    @Composable
    fun ContohRow(){
        val context = LocalContext.current

        Column (
            modifier = Modifier
                .verticalScroll(
                    enabled = true,
                    state = ScrollState(0)
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(1f))
            Text(
                text = "Android Development Tool",
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
            ){
                Text(
                    text = "Android Studio Chipmunk",
                    fontWeight = FontWeight(600),
                    modifier = Modifier
                        .padding(top = 16.dp),
                    fontSize = 15.sp)
                Text(
                    text = "Versi 2021.02.01",
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 15.sp
                )
            }
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Ini merupakan android studio versi terbaru",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .width(200.dp)
            ){
                Text(text = "Click Me!")
            }
        }
    }
}