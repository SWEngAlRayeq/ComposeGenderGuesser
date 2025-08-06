package app.gender_guesser.data.model

data class GenderResponse(
    val name: String,
    val gender: String,
    val probability: Double,
    val count: Int
)