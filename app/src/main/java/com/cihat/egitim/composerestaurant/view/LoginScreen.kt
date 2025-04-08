package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cihat.egitim.composerestaurant.R
import com.cihat.egitim.composerestaurant.navigation.nav_forgotPasswordScreen
import com.cihat.egitim.composerestaurant.navigation.nav_homeScreen
import com.cihat.egitim.composerestaurant.navigation.nav_signupScreen
import com.cihat.egitim.composerestaurant.ui.theme.ComposeRestaurantTheme

@Composable
fun LoginScreen(modifier: Modifier, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = "Illustration",
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Başlık
        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        // Email TextField
        CustomTextField(
            value = email,
            onvalueChange = { email = it },
            label = "Email ID or Mobile",
            icon = R.drawable.calling,
        )

        // Password TextField
        CustomTextField(
            value = password,
            onvalueChange = { password = it },
            label = "Password",
            icon = R.drawable.password,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Forgot password
        Text(
            text = "Forgot password?",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 12.dp)
                .clickable {
                    navController.navigate(nav_forgotPasswordScreen)
                }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Continue Button
        Button(
            onClick = { navController.navigate(nav_homeScreen) },
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

        // Forgot password

        // "OR" çizgileriyle birlikte
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .padding(end = 10.dp, start = 24.dp),
                color = Color.LightGray
            )
            Text(
                text = "OR",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium
            )
            HorizontalDivider(modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .padding(start = 10.dp, end = 24.dp),
                color = Color.LightGray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        SocialLoginButton(
            text = "Login with Google",
            icon = painterResource(id = R.drawable.google_icon),
            onClick = { navController.navigate(nav_homeScreen) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        SocialLoginButton(
            text = "Login with Facebook",
            icon = painterResource(id = R.drawable.facebook_icon),
            onClick = { navController.navigate(nav_homeScreen) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(text = "New to us?", fontSize = 14.sp, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Register",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable {
                    navController.navigate(nav_signupScreen)
                }
            )
        }


    }
}

@Composable
fun SocialLoginButton(text: String, icon: Painter, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(text = text, fontSize = 16.sp,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    ComposeRestaurantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LoginScreen(Modifier.padding(innerPadding),
                navController = NavController(context = LocalContext.current))
        }
    }
}
