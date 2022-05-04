package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
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
fun InfoCard(
    title: String,
    text: String
) {
    Column(
        modifier = Modifier
            .padding(30.dp)
            .background(
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(15.dp),
            color = MaterialTheme.colors.onPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                )
                .padding(15.dp)
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}
