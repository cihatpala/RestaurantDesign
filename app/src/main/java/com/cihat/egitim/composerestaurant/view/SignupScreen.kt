package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.cihat.egitim.composerestaurant.R
import com.cihat.egitim.composerestaurant.enums.SuccessSource
import com.cihat.egitim.composerestaurant.navigation.nav_loginScreen
import com.cihat.egitim.composerestaurant.navigation.nav_signupConfirmScreen
import com.cihat.egitim.composerestaurant.ui.theme.ComposeRestaurantTheme




@Composable
fun SignUpScreen(modifier: Modifier, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

        Spacer(modifier = Modifier.height(16.dp))

        // Başlık
        Text(
            text = "Sign up",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email TextField
        CustomTextField(
            value = email,
            onvalueChange = { email = it },
            label = "Email",
            icon = R.drawable.work,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Full Name TextField
        CustomTextField(
            value = fullName,
            onvalueChange = { fullName = it },
            label = "Full name",
            icon = R.drawable.profile,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mobile TextField
        CustomTextField(
            value = mobile,
            onvalueChange = { mobile = it },
            label = "Mobile",
            icon = R.drawable.calling,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        CustomTextField(
            value = password,
            onvalueChange = { password = it },
            label = "Password",
            icon = R.drawable.password,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Terms & Conditions
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(
                    text = "By Signing up, you're agree to our ",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Term & Conditions",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }
            Row {
                Text(
                    text = "and ",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Privacy Policy",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Continue Button
        Button(
            onClick = { navController.navigate("$nav_signupConfirmScreen/${SuccessSource.FROM_SIGNUP.name}") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7FFFD4))
        ) {
            Text(
                text = "Continue",
                color = Color.Black,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Login Text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Text(
                text = "Joined before? ",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium

            )
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(nav_loginScreen)
                },
                text = "Login",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    ComposeRestaurantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SignUpScreen(Modifier.padding(innerPadding),
                navController = NavController(context = LocalContext.current))
        }
    }
}
