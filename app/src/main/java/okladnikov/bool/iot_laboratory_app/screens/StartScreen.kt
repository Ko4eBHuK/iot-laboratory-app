package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import okladnikov.bool.iot_laboratory_app.R
import okladnikov.bool.iot_laboratory_app.ui.elements.CardWithTitle
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar
import okladnikov.bool.iot_laboratory_app.ui.elements.TitleText

@Composable
fun StartScreen() {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Инофрмация")
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
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
