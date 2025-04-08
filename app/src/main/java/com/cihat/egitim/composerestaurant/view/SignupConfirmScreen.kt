package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cihat.egitim.composerestaurant.R
import com.cihat.egitim.composerestaurant.enums.SuccessSource
import com.cihat.egitim.composerestaurant.navigation.nav_loginScreen
import com.cihat.egitim.composerestaurant.ui.theme.ComposeRestaurantTheme

@Composable
fun SignupConfirmScreen(modifier: Modifier, navController: NavController, successType: SuccessSource) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Üstteki görsel
        Image(
            painter = painterResource(id = R.drawable.signup_image),
            contentDescription = "Illustration",
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(55.dp))

        // Üstteki görsel
        Image(
            painter = painterResource(id = R.drawable.message_sent_image),
            contentDescription = "Illustration",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = when (successType) {
            SuccessSource.FROM_RESET_PASSWORD -> "Reset Password in Successfully"
            SuccessSource.FROM_SIGNUP -> "Signed up Successfully"
            else -> {
                "Err success_?"
            }
        },
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.weight(1f))
        // Continue Button
        Button(
            onClick = { navController.navigate(nav_loginScreen) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7FFFD4))
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpConfirmScreenPreview() {
    ComposeRestaurantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SignupConfirmScreen(Modifier.padding(innerPadding),
                navController = NavController(context = LocalContext.current), SuccessSource.FROM_RESET_PASSWORD)
        }
    }
}
