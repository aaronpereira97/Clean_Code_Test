package com.ml.photosearchapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ml.photosearchapp.domain.Results
import com.ml.photosearchapp.domain.UnsplashResponse
import com.ml.photosearchapp.domain.authored.AuthoredPhotoResponse
import com.ml.photosearchapp.network.PhotoApi
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Singleton

private const val INITIAL_LOAD_KEY = 1

class AuthoredPhotoPagingSource(
    private val username: String,
    private val photoApi: PhotoApi
) : PagingSource<Int, AuthoredPhotoResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AuthoredPhotoResponse> {
        return try {
            val position = params.key ?: INITIAL_LOAD_KEY

            val response = photoApi.getAuthoredPhotos(
                username,
                page = position,
                perPage = params.loadSize
            )

            LoadResult.Page(
                data = response,
                prevKey = if (position == INITIAL_LOAD_KEY) null else position - 1,
                nextKey = if (response.isNullOrEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)

        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AuthoredPhotoResponse>): Int? = null
}