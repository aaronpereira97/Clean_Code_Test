package com.ml.photosearchapp.network

import com.ml.photosearchapp.BuildConfig
import com.ml.photosearchapp.domain.UnsplashResponse
import com.ml.photosearchapp.domain.authored.AuthoredPhotoResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoApi {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }

    @Headers("Authorization: Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("search/photos")
    suspend fun getPhotos(
            @Query("query") query: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ) : UnsplashResponse

    @Headers("Authorization: Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("users/{username}/photos")
    suspend fun getAuthoredPhotos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ) : List<AuthoredPhotoResponse>

}