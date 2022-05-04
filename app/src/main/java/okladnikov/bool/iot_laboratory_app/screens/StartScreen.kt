package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import okladnikov.bool.iot_laboratory_app.R
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomAppBar
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.InfoCard
import okladnikov.bool.iot_laboratory_app.ui.elements.Title

@Preview
@Composable
fun StartScreen() {
    Scaffold(
        bottomBar = {
            DefaultBottomAppBar()
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(10.dp, 10.dp, 10.dp, 10.dp)
        ) {
            Title(stringResource(R.string.start_screen_title))

            InfoCard(
                title = "О приложении",
                text = stringResource(R.string.start_screen_text)
            )
        }
    }
}
