package app.gender_guesser.data.remote

import app.gender_guesser.data.model.GenderResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenderApi {

    @GET("/")
    suspend fun guessGender(@Query("name") name: String): GenderResponse
    
}