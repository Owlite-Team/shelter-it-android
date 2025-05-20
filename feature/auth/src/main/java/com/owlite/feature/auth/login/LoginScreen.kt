package com.owlite.feature.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owlite.feature.auth.R

@Composable
fun LoginScreen() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bg_login_form),
            contentDescription = stringResource(R.string.desc_bg),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            containerColor = Color.Transparent,
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                OutlinedTextField(
                    value = "Username",
                    onValueChange = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(1000.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = DarkCharcoal
                    ),
                )

//                BasicTextField(
//                    value = text,
//                    onValueChange = { text = it },
//                    modifier = Modifier,
//                    interactionSource = interactionSource,
//                    enabled = enabled,
//                    singleLine = singleLine,
//                    textStyle = LocalTextStyle.current,
//                    decorationBox = { innerTextField ->
//                        OutlinedTextFieldDefaults.DecorationBox(
//                            value = text,
//                            innerTextField = innerTextField,
//                            visualTransformation = VisualTransformation.None,
//                            singleLine = singleLine,
//                            enabled = enabled,
//                            isError = isError,
//                            interactionSource = interactionSource,
//                            container = {
//                                OutlinedTextFieldDefaults.Container(
//                                    enabled = enabled,
//                                    isError = isError,
//                                    interactionSource = interactionSource,
//                                    // Update border thickness and shape
//                                    shape = RectangleShape,
//                                    unfocusedBorderThickness = 2.dp,
//                                    focusedBorderThickness = 4.dp
//                                )
//                            },
//                        )
//                    }
//                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}