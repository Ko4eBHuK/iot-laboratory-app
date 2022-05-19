package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardWithTitle(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.surface,
                shape = MaterialTheme.shapes.small
            )
            .width(IntrinsicSize.Max),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(15.dp),
                color = MaterialTheme.colors.onPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Box(
            modifier = Modifier.padding(15.dp)
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            content()
        }
    }
}
