package com.cihat.egitim.composerestaurant.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cihat.egitim.composerestaurant.R

@Composable
fun CustomTextField(
    value: String,
    onvalueChange: (String) -> Unit,
    label: String,
    icon: Int,
    isPassword: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }
    Box {
        TextField(
            value = value,
            onValueChange = { onvalueChange(it) },
            leadingIcon = {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = label + " Icon",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(text = label,
                    style = MaterialTheme.typography.bodyMedium)
            },
            trailingIcon = {
                if (isPassword) {
                    val image = if (passwordVisible) {
                        Icons.Filled.VisibilityOff
                    } else {
                        Icons.Filled.Visibility
                    }

//                    val painterResId = if (passwordVisible) {
//                        R.drawable.show_password
//                    } else {
//                        R.drawable.hide_password
//                    }

//                    val painterRes = painterResource(id = painterResId)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(modifier = Modifier.size(30.dp),
                            imageVector = image,
                            contentDescription = "Toggle Password Visibility")
                    }
                }
            },
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
        Divider(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 52.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}