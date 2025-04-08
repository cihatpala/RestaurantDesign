package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.cihat.egitim.composerestaurant.R
import com.cihat.egitim.composerestaurant.models.RestaurantModel
import com.cihat.egitim.composerestaurant.service.RestaurantAPI
import com.cihat.egitim.composerestaurant.ui.theme.ComposeRestaurantTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(modifier: Modifier, navController: NavController) {
    val BASE_URL = "https://raw.githubusercontent.com/"
    var restaurantList = remember { mutableStateListOf<RestaurantModel>() }
//    restaurantList.add(RestaurantModel("Sultanbeyli Restaurant", 3, true, "R.drawable.login_image", 15))
//    restaurantList.add(RestaurantModel("Sancaktepe Restaurant", 12, false, R.drawable.sample_food, 1))
//    restaurantList.add(RestaurantModel("Newyork Restaurant", 5, true, R.drawable.signup_image, 5))
//    restaurantList.add(RestaurantModel("Kartal Restaurant", 1, true, R.drawable.forgot_password_image, 3))
//    restaurantList.add(RestaurantModel("Sultanbeyli Restaurant", 3, true, R.drawable.login_image, 15))
//    restaurantList.add(RestaurantModel("Sancaktepe Restaurant", 2, false, R.drawable.sample_food, 1))
//    restaurantList.add(RestaurantModel("Newyork Restaurant", 5, true, R.drawable.signup_image, 5))
//    restaurantList.add(RestaurantModel("Kartal Restaurant", 1, true, R.drawable.forgot_password_image, 3))
//    restaurantList.add(RestaurantModel("Sultanbeyli Restaurant", 3, true, R.drawable.login_image, 15))
//    restaurantList.add(RestaurantModel("Sancaktepe Restaurant", 2, false, R.drawable.sample_food, 1))
//    restaurantList.add(RestaurantModel("Newyork Restaurant", 5, true, R.drawable.signup_image, 5))
//    restaurantList.add(RestaurantModel("Kartal Restaurant", 1, true, R.drawable.forgot_password_image, 3))

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RestaurantAPI::class.java)

    val call = retrofit.getData()

    call.enqueue(object : Callback<List<RestaurantModel>> {
        override fun onResponse(p0: Call<List<RestaurantModel>>, p1: Response<List<RestaurantModel>>) {
            if (p1.isSuccessful) {
                p1.body()?.let {
                    //list
                    restaurantList.addAll(it)
                }
            }
        }

        override fun onFailure(p0: Call<List<RestaurantModel>>, p1: Throwable) {
            p1.printStackTrace()
        }

    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(100, 252, 217)) // üst kısım arka plan rengi
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        CardList(restaurantList)
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Menu, contentDescription = "Menu")
        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
    }
}

@Composable
fun SearchBar() {
    val colorsTransparent = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
//        focusedIndicatorColor = Color.Transparent,
//        unfocusedIndicatorColor = Color.Transparent,
    )
    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text("Search for Shops and Restaurants",
                style = MaterialTheme.typography.bodyMedium)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = colorsTransparent,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon"
            )
        },
    )
}

@Composable
fun CardList(restaurants: List<RestaurantModel>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 16.dp)
        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(restaurant)
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(181.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(217, 217, 217))
                    )
                )
        )
    }
}

@Composable
fun RestaurantCard(restaurant: RestaurantModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = restaurant.image,
                contentDescription = null,
                modifier = Modifier
                    .size(86.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
//            Image(
//                painter = painterResource(id = restaurant.image), // örnek resim
//                contentDescription = "Restaurant Image",
//                modifier = Modifier
//                    .size(86.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                contentScale = ContentScale.Crop
//            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(restaurant.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyMedium)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    var rate = restaurant.rate
                    if (rate > 5) {
                        rate = 5
                    }
                    repeat(rate) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107), modifier = Modifier.size(16.dp))
                    }
                    repeat(5 - rate) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(210, 210, 210), modifier = Modifier.size(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                if (restaurant.recommendedTag) {
                    Text(
                        text = "Recommended",
                        modifier = Modifier
                            .background(Color.LightGray, shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(R.drawable.database_icon), contentDescription = null, modifier = Modifier.size(8.dp))
                    Text(text = restaurant.stock.toString(),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.bodyMedium)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeRestaurantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeScreen(Modifier.padding(innerPadding),
                navController = NavController(context = LocalContext.current))
        }
    }
}

