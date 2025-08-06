package app.gender_guesser.domain.usecase

import app.gender_guesser.domain.repo.GenderRepository
import javax.inject.Inject

class GuessGenderUseCase @Inject constructor(
    private val genderRepository: GenderRepository
) {
    suspend operator fun invoke(name: String) = genderRepository.guessGender(name)
}