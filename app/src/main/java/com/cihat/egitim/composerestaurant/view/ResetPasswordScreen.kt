package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.cihat.egitim.composerestaurant.navigation.nav_signupConfirmScreen
import com.cihat.egitim.composerestaurant.ui.theme.ComposeRestaurantTheme

@Composable
fun ResetPasswordScreen(modifier: Modifier, navController: NavController) {
    var newpassword by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(40.dp))

//        // Üstteki görsel
        Image(
            painter = painterResource(id = R.drawable.reset_password_image),
            contentDescription = "Illustration",
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Başlık
        Text(
            text = "Reset",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )
        // Başlık2
        Text(
            text = "Password",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Email TextField
        CustomTextField(
            value = newpassword,
            onvalueChange = { newpassword = it },
            label = "New Password",
            icon = R.drawable.password,
            isPassword = true
        )

        // Email TextField
        CustomTextField(
            value = confirmpassword,
            onvalueChange = { confirmpassword = it },
            label = "Confirm Password",
            icon = R.drawable.password,
            isPassword = true
        )

        // Continue Button
        Button(
            onClick = { navController.navigate(nav_signupConfirmScreen + "/${SuccessSource.FROM_RESET_PASSWORD.name}") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7FFFD4))
        ) {
            Text(
                text = "Submit",
                color = Color.Black,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ResetPasswordScreenPreview() {
    ComposeRestaurantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ResetPasswordScreen(Modifier.padding(innerPadding),
                navController = NavController(context = LocalContext.current))
        }
    }
}