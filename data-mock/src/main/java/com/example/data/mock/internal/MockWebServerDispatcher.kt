package com.example.data.mock.internal

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockWebServerDispatcher(private val assetProvider: AssetProvider) : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        val actorsRegex = """/3/movie/(\d+)/credits""".toRegex()
        val movieDetailRegex = """/3/movie/(\d+)""".toRegex()
        val path: String = request.path.orEmpty()
        return when {
            path == "/3/movie/upcoming" -> {
                assetProvider.createResponseFromAssets(fileName = "UpComing.json")
            }

            path == "/3/movie/top_rated" -> {
                assetProvider.createResponseFromAssets(fileName = "TopRated.json")
            }

            path == "/3/genre/movie/list" -> {
                assetProvider.createResponseFromAssets(fileName = "Genres.json")
            }

            path == "/3/movie/popular" -> {
                assetProvider.createResponseFromAssets(fileName = "Popular.json")
            }

            path == "/3/movie/now_playing" -> {
                assetProvider.createResponseFromAssets(fileName = "NowPlaying.json")
            }
            actorsRegex.matches(path) -> {
                assetProvider.createResponseFromAssets(fileName = "Actors.json")
            }
            movieDetailRegex.matches(path) -> {
                assetProvider.createResponseFromAssets(fileName = "Details.json")
            }
            else -> {
                println("path not Handle : $path")
                assetProvider.createEmptyResponse()
            }
        }
    }
}
