package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.SemanticsProperties.ContentDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Icon
import androidx.navigation.NavController

import okladnikov.bool.iot_laboratory_app.ui.elements.*

@Composable
fun HouseControlScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Управление помещением")
        },
        bottomBar = {
            DefaultBottomAppBar(navController)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
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
                CardWithTitle(title = "Устройство лампочка") {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Включить"
                    )
                }
            }
        }
    }
}
