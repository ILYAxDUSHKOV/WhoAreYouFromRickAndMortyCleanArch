package com.example.whoareyoufromrickandmortycleanarch.presentation.composable

import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.whoareyoufromrickandmortycleanarch.R
import com.example.whoareyoufromrickandmortycleanarch.presentation.RAMViewModel

@Composable
fun WhoAreYouScreen(
    navController: NavController,
    viewModel:RAMViewModel
){
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components{
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(130.dp))
        Text(
            text = "Who are you from...",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context).data(R.drawable.load).build(),
                imageLoader = imageLoader
            ),
            modifier = Modifier
                .size(260.dp, 260.dp),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "...Rick and Morty?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(80.dp))
        FloatingActionButton(
            modifier = Modifier
                .border(2.dp, Color.White, CircleShape),
            backgroundColor = Color.Black,
            onClick = {
                viewModel.LoadRAMData()
                navController.navigate(Screens.InfoScreen.route)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}