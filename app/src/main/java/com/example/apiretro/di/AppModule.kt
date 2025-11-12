package com.example.apiretro.di

import com.example.apiretro.data.APIGames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.apiretro.utils.Constants



@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit(BASE_URL: Any): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.Companion.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesAPIGames(retrofit: Retrofit): APIGames {
        return retrofit.create(APIGames::class.java)
    }
}
