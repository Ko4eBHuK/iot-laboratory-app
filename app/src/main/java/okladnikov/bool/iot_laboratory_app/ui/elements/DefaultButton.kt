package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import okladnikov.bool.iot_laboratory_app.ui.theme.*

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Blue, contentColor = LightBlue)
    ) {
        Text(text)
    }
}
