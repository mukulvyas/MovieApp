package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.movieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movie App") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
                //elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),

            )
        }
    )  {
            innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            MainContent(navController = navController)
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String>  = listOf(
    "Avatar",
    "300",
    "Harry Potter",
    "Life",
    "Iron Man",
    "Avenger",
    "lord of ring",
    "sheldon",
    "black clover",
    "Captian America"
)){

    Column(modifier = Modifier.padding(15.dp)) {
        LazyColumn{
            items(items = movieList){
                movieRow(movie = it){movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")

                    //Log.d("TAG  ","MainContent : $movie")
                }
                //Text(text = it)
            }
        }
    }




}
