package app.gender_guesser.domain.repo

import app.gender_guesser.data.model.GenderResponse

interface GenderRepository {

    suspend fun guessGender(name: String): GenderResponse

}