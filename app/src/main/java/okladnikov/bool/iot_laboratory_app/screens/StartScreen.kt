package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import okladnikov.bool.iot_laboratory_app.R
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomAppBar
import okladnikov.bool.iot_laboratory_app.ui.elements.CardWithTitle
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar
import okladnikov.bool.iot_laboratory_app.ui.elements.TitleText

@Composable
fun StartScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Инофрмация")
        },
        bottomBar = {
            DefaultBottomAppBar(navController)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TitleText(stringResource(R.string.start_screen_title))

            CardWithTitle(
                title = "О приложении",
            ) {
                Text(
                    text = stringResource(R.string.start_screen_text),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}
