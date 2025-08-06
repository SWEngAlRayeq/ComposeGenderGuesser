package app.gender_guesser.data.repo_impl

import app.gender_guesser.data.model.GenderResponse
import app.gender_guesser.data.remote.GenderApi
import app.gender_guesser.domain.repo.GenderRepository
import javax.inject.Inject

class GenderRepositoryImpl @Inject constructor(
    private val genderApi: GenderApi
) : GenderRepository {
    override suspend fun guessGender(name: String): GenderResponse =
        genderApi.guessGender(name)
}