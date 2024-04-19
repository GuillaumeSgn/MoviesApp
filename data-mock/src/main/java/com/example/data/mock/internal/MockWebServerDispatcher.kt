package com.example.data.mock.internal

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockWebServerDispatcher(private val assetProvider: AssetProvider) : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        val path: String = request.path.orEmpty()
        return when (path) {
            "/3/movie/upcoming" -> {
                assetProvider.createResponseFromAssets(fileName = "UpComing.json")
            }
            "/3/movie/top_rated" -> {
                assetProvider.createResponseFromAssets(fileName = "TopRated.json")
            }
            "/3/genre/movie/list" -> {
                assetProvider.createResponseFromAssets(fileName = "Genres.json")
            }
            "/3/movie/popular" -> {
                assetProvider.createResponseFromAssets(fileName = "Popular.json")
            }
            "/3/movie/now_playing" -> {
                assetProvider.createResponseFromAssets(fileName = "NowPlaying.json")
            }
            else -> {
                println("path not Handle : $path")
                assetProvider.createEmptyResponse()
            }
        }
    }
}
