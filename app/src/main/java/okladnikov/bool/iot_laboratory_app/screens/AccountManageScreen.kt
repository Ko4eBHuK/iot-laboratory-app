package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import okladnikov.bool.iot_laboratory_app.ui.elements.*

@Composable
fun AccountManageScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Управление аккаунтом")
        },
        bottomBar = {
            DefaultBottomAppBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            DefaultTextField(
                label = "Новый пароль",
                modifier = Modifier.padding(30.dp),
                visualTransformation = PasswordVisualTransformation()
            )

            DefaultTextField(
                label = "Повторите новый пароль",
                modifier = Modifier.padding(30.dp),
                visualTransformation = PasswordVisualTransformation()
            )

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(30.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = MaterialTheme.shapes.small
                    )
                    .width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box( modifier = Modifier.fillMaxWidth() ) {
                    DefaultButton(
                        onClick = {
                            /*TODO*/
                        },
                        text = "Сменить пароль"
                    )
                }

                Box( modifier = Modifier.fillMaxWidth() ) {
                    DefaultButton(
                        onClick = {
                            /*TODO*/
                        },
                        text = "Выйти"
                    )
                }
            }
        }
    }
}
