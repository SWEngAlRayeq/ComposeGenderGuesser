package app.gender_guesser.di

import app.gender_guesser.data.remote.GenderApi
import app.gender_guesser.data.repo_impl.GenderRepositoryImpl
import app.gender_guesser.domain.repo.GenderRepository
import app.gender_guesser.domain.usecase.GuessGenderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://api.genderize.io/"

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(
        baseUrl: String,
        client: OkHttpClient
    ): GenderApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GenderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: GenderApi): GenderRepository =
        GenderRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideUseCase(repo: GenderRepository): GuessGenderUseCase =
        GuessGenderUseCase(repo)

}
