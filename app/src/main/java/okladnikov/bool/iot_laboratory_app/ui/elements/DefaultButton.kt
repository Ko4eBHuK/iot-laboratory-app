package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import okladnikov.bool.iot_laboratory_app.ui.theme.*

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Blue, contentColor = LightBlue)
    ) {
        Text(text)
    }
}
