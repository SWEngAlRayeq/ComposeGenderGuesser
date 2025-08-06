package app.gender_guesser.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.gender_guesser.data.model.GenderResponse
import app.gender_guesser.domain.usecase.GuessGenderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GenderViewModel @Inject constructor(
    private val guessGenderUseCase: GuessGenderUseCase
) : ViewModel() {

    var name by mutableStateOf("")
    var result by mutableStateOf<GenderResponse?>(null)
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    fun guessGender() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                result = guessGenderUseCase(name)
            } catch (e: Exception) {
                error = e.message
            }
            isLoading = false
        }
    }
}