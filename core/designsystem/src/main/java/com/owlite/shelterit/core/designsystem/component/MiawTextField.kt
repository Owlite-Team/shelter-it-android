package com.owlite.shelterit.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owlite.shelterit.core.designsystem.theme.Brown30
import com.owlite.shelterit.core.designsystem.theme.Brown70
import com.owlite.shelterit.core.designsystem.theme.Gray20
import com.owlite.shelterit.core.designsystem.theme.Gray50
import com.owlite.shelterit.core.designsystem.theme.ShelterItTheme

@Composable
fun MiawOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isPassword: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onImeAction: () -> Unit = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp),
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = { onImeAction() },
            onNext = { onImeAction() },
            onGo = { onImeAction() },
            onSearch = { onImeAction() },
            onSend = { onImeAction() }
        ),
        singleLine = singleLine,
        maxLines = maxLines,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = RoundedCornerShape(1000.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Brown70,
            unfocusedBorderColor = Brown70,
            disabledBorderColor = Gray20,
            focusedTextColor = Brown70,
            unfocusedTextColor = Brown70,
            disabledTextColor = Gray50,
            focusedPlaceholderColor = Gray50,
            unfocusedPlaceholderColor = Gray50,
            cursorColor = Brown70,
            focusedContainerColor = Brown30,
            unfocusedContainerColor = Brown30,
            disabledContainerColor = Gray20
        )
    )
}

// Usage Examples
@Preview(showBackground = true)
@Composable
fun MiawOutlinedTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ShelterItTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Basic text field
            MiawOutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = "Enter your name"
            )

            // Password field
            MiawOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )

            // Email field
            MiawOutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = "Email address",
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

            // Disabled field
            MiawOutlinedTextField(
                value = "Disabled field",
                onValueChange = { },
                placeholder = "Disabled",
                enabled = false
            )
        }
    }
}
