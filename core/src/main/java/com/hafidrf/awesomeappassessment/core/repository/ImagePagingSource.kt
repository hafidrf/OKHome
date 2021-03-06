package com.hafidrf.awesomeappassessment.core.repository

import androidx.paging.PagingSource
import com.hafidrf.awesomeappassessment.core.model.Image
import com.hafidrf.awesomeappassessment.core.api.ApiService

class ImagePagingSource(private val apiService: ApiService) : PagingSource<Int, Image>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        return try {
            val nextPage = params.key ?: 1
            val response = apiService.getAllImage(nextPage)

            val result = mutableListOf<Image>()
            response.photos?.let { result.addAll(it) }

            LoadResult.Page(
                data = result,
                prevKey = null,
                nextKey = if (nextPage == 10) null else nextPage.plus(1)
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

}