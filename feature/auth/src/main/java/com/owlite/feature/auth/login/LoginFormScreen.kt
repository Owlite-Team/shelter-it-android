package com.owlite.feature.auth.login

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.owlite.feature.auth.R
import com.owlite.shelterit.core.designsystem.component.MiawButton
import com.owlite.shelterit.core.designsystem.component.MiawOutlinedTextField
import com.owlite.shelterit.core.designsystem.theme.LocalComponentDimensions

@Composable
fun LoginFormScreen() {
    val dimensions = LocalComponentDimensions.current

    Box {
        AsyncImage(
            model = R.drawable.bg_login_form,
            contentDescription = stringResource(R.string.desc_bg),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Scaffold(
            containerColor = Color.Transparent,
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                MiawOutlinedTextField(
                    value = "text",
                    onValueChange = { it },
                    placeholder = "Email address",
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(8.dp))
                MiawOutlinedTextField(
                    value = "password",
                    onValueChange = { it },
                    placeholder = "Password",
                    isPassword = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Forgot password?",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(24.dp))
                MiawButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensions.buttonHeight),
                    text = "Login"
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginFormScreen()
}
