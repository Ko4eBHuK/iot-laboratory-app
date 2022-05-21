package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomNavigationBar
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTextField
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar

@Composable
fun AccountManageScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Управление аккаунтом")
        }
    ) {
        val localFocusManager = LocalFocusManager.current

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .pointerInput(Unit) { detectTapGestures(
                    onTap = { localFocusManager.clearFocus() }
                )},
        ) {

            Box{}

            DefaultTextField(
                label = "Новый пароль",
                visualTransformation = PasswordVisualTransformation()
            )

            DefaultTextField(
                label = "Повторите новый пароль",
                visualTransformation = PasswordVisualTransformation()
            )

            DefaultButton(
                onClick = {
                    localFocusManager.clearFocus()
                    //TODO - implement password changing
                },
                text = "Сменить пароль"
            )

            DefaultButton(
                onClick = {
                    localFocusManager.clearFocus()
                    navController.navigate("logOut")
                },
                text = "Выйти",
                modifier = Modifier.padding(top = 8.dp, bottom = 60.dp)
            )
        }
    }
}
