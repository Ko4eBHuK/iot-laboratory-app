package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import okladnikov.bool.iot_laboratory_app.ui.elements.*

@Preview
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Вход")
        },
        bottomBar = {
            DefaultBottomAppBar()
        }
    ) {
        val localFocusManager = LocalFocusManager.current

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
                .pointerInput(Unit) { detectTapGestures(
                    onTap = { localFocusManager.clearFocus() }
                    )},
        ) {

            DefaultTextField(
                label = "Логин или E-mail",
                modifier = Modifier.padding(30.dp)
            )

            DefaultTextField(
                label = "Пароль",
                modifier = Modifier.padding(30.dp),
                visualTransformation = PasswordVisualTransformation()
            )

            DefaultButton(
                onClick = {
                    localFocusManager.clearFocus()
                          },
                text = "Войти"
            )
        }
    }
}
