package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import kotlinx.coroutines.launch

import okladnikov.bool.iot_laboratory_app.network.login
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTextField
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar
import okladnikov.bool.iot_laboratory_app.ui.theme.Blue
import okladnikov.bool.iot_laboratory_app.ui.theme.LightBlue

@Composable
fun LoginScreen(
    navController: NavController,
    userCookie: String,
    changeCookie: (String) -> Unit
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Вход")
        }
    ) {
        val localFocusManager = LocalFocusManager.current
        val coroutineScope = rememberCoroutineScope()
        var login by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var loadingElementVisibility by remember { mutableStateOf(false) }
        val openDialog = remember { mutableStateOf(false) }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { localFocusManager.clearFocus() }
                    )
                },
        ) {

            Box{}

            TextField(
                value = login,
                onValueChange = { login = it },
                label = { Text("Логин или E-mail") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
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

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Пароль") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                visualTransformation = PasswordVisualTransformation(),
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

            DefaultButton(
                onClick = {
                    coroutineScope.launch {
                        loadingElementVisibility = true

                        localFocusManager.clearFocus()

                        //TODO change below lines
                        val cookieString = login("Ko4eBHuK", "Sharks_05Fankintronic")
                        //val cookieString = login(login.text, password.text)

                        if ("%3D%3D" in cookieString) {
                            changeCookie(cookieString)
                            navController.navigate("houseManage/${true}")
                        } else {
                            openDialog.value = true
                        }

                        loadingElementVisibility = false
                    }
                },
                text = "Войти",
                modifier = Modifier.padding(bottom = 60.dp)
            )

            if(loadingElementVisibility){
                CircularProgressIndicator(
                    color = Blue
                )
            }

            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    shape = MaterialTheme.shapes.small,
                    title = { Text(text = "Неверные данные") },
                    text = { Text("Вы ввели неверный логин или пароль") },
                    buttons = {
                        Button(
                            onClick = { openDialog.value = false }
                        ) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}
