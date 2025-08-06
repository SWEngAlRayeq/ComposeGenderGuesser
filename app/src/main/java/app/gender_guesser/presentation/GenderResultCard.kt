package app.gender_guesser.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.gender_guesser.data.model.GenderResponse

@Composable
fun GenderResultCard(result: GenderResponse) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Name: ${result.name}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Gender: ${result.gender}", fontSize = 16.sp)
            Text("Probability: ${(result.probability * 100).toInt()}%", fontSize = 14.sp)
            Text("Based on ${result.count} samples", fontSize = 12.sp, color = Color.Gray)
        }
    }
}