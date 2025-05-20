package com.owlite.shelterit.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.owlite.shelterit.core.designsystem.theme.Brown70
import com.owlite.shelterit.core.designsystem.theme.Gray20
import com.owlite.shelterit.core.designsystem.theme.Gray50
import com.owlite.shelterit.core.designsystem.theme.ShelterItTheme
import com.owlite.shelterit.core.designsystem.theme.White

@Composable
fun MiawButton(
    modifier: Modifier = Modifier,
    text: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    shape: Shape = CircleShape,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Brown70,
            contentColor = White,
            disabledContainerColor = Gray20,
            disabledContentColor = Gray50,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp
        ),
        border =
            if (enabled) BorderStroke(1.dp, Brown70)
            else BorderStroke(1.dp, color = Gray20),
        contentPadding = ButtonDefaults.ContentPadding,
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            leadingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = "Favorite Icon",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
            trailingIcon?.let {
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(
                    imageVector = it,
                    contentDescription = "Favorite Icon",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiawButtonPreview() {
    ShelterItTheme {
        Column {
            // Default
            MiawButton(
                modifier = Modifier.padding(16.dp),
                text = "Shelter It",
                onClick = { /* Do something */ },
            )

            // With leading icon
            MiawButton(
                modifier = Modifier.padding(16.dp),
                text = "Shelter It",
                leadingIcon = Icons.Default.Favorite,
                onClick = { /* Do something */ },
            )

            // With trailing icon
            MiawButton(
                modifier = Modifier.padding(16.dp),
                text = "Shelter It",
                trailingIcon = Icons.Default.Favorite,
                onClick = { /* Do something */ },
            )

            // Disabled
            MiawButton(
                modifier = Modifier.padding(16.dp),
                text = "Shelter It",
                trailingIcon = Icons.Default.Favorite,
                enabled = false,
                onClick = { /* Do something */ },
            )
        }
    }
}
