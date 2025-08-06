package app.gender_guesser.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.gender_guesser.presentation.viewmodel.GenderViewModel

@Composable
fun GenderScreen(viewModel: GenderViewModel = hiltViewModel()) {

    val name = viewModel.name
    val result = viewModel.result
    val isLoading = viewModel.isLoading
    val error = viewModel.error

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Color(0xFF121212))
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "👥 Gender Guesser",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
            )

        Spacer(modifier = Modifier.height(24.dp))


        OutlinedTextField(
            value = name,
            onValueChange = { viewModel.name = it },
            label = { Text(text = "Enter Name") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color(0xFF1DB954),
                unfocusedLabelColor = Color.Gray,
                focusedIndicatorColor = Color(0xFF1DB954),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {viewModel.guessGender()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1DB954))
        ) {
            Text("🔍 Guess Gender", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        when {
            isLoading -> CircularProgressIndicator(color = Color.White)
            error != null -> Text("❌ $error", color = Color.Red)
            result != null -> GenderResultCard(result)
        }
    }

}