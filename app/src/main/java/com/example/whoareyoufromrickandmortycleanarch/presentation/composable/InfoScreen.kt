package com.example.whoareyoufromrickandmortycleanarch.presentation.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.whoareyoufromrickandmortycleanarch.presentation.RAMViewModel

@Composable
fun InfoScreen(
    viewModel:RAMViewModel
){
    viewModel.state.RAMData?.let { data ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(300.dp,300.dp),
                    model = data.image,
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data.name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ){
                Column() {
                    Text(
                        text = "Status: " + data.status,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Species: " + data.species,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    if (data.type.isNotEmpty()){
                        Text(
                            text = "Type: " + data.type,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    } else {
                        Text(
                            text = "Type: unknown",
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Gender: " + data.gender,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
    if(viewModel.state.isLoading){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ){
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
    viewModel.state.error?.let { error ->
        Log.d("MyError", error)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ){
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}