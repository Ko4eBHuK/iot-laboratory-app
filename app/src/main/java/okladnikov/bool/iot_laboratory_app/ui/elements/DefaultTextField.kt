package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

import okladnikov.bool.iot_laboratory_app.ui.theme.*

@Composable
fun DefaultTextField(
    label: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Blue,
            disabledTextColor = Blue,
            backgroundColor = LightBlue,
            cursorColor = Blue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Blue,
            unfocusedLabelColor = Blue,
            placeholderColor = Blue
        )
    )
}
