package com.cihat.egitim.composerestaurant.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cihat.egitim.composerestaurant.enums.SuccessSource
import com.cihat.egitim.composerestaurant.view.ForgotPasswordScreen
import com.cihat.egitim.composerestaurant.view.HomeScreen
import com.cihat.egitim.composerestaurant.view.LoginScreen
import com.cihat.egitim.composerestaurant.view.ResetPasswordScreen
import com.cihat.egitim.composerestaurant.view.SignUpScreen
import com.cihat.egitim.composerestaurant.view.SignupConfirmScreen
import com.cihat.egitim.composerestaurant.view.StartScreen

const val nav_startScreen = "start_screen"
const val nav_signupScreen = "signup_screen"
const val nav_loginScreen = "login_screen"
const val nav_forgotPasswordScreen = "forgot_passwordScreen"
const val nav_resetPasswordScreen = "reset_passwordScreen"
const val nav_signupConfirmScreen = "signup_confirmScreen"
const val nav_homeScreen = "home_screen"

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = nav_startScreen,
        modifier = modifier
    ) {
        composable(route = nav_startScreen) {
            StartScreen(modifier, navController)
        }
        composable(route = nav_signupScreen) {
            SignUpScreen(modifier, navController)
        }
        composable(route = nav_loginScreen) {
            LoginScreen(modifier, navController)
        }
        composable(route = nav_forgotPasswordScreen) {
            ForgotPasswordScreen(modifier, navController)
        }
        composable(route = nav_resetPasswordScreen) {
            ResetPasswordScreen(modifier, navController)
        }
        composable( route = "$nav_signupConfirmScreen/{successType}",
            arguments = listOf(navArgument("successType") { type = NavType.StringType })) {
            val sourceString = it.arguments?.getString("successType") ?: SuccessSource.FROM_SIGNUP.name
            val successType = try {
                SuccessSource.valueOf(sourceString) // String'i Enum'a çevir
            } catch (e: IllegalArgumentException) {
                SuccessSource.FROM_SIGNUP  // Geçersiz değer gelirse default değeri kullan
            }
            SignupConfirmScreen(modifier, navController, successType)
        }
        composable(route = nav_homeScreen) {
            HomeScreen(modifier, navController)
        }
    }
}