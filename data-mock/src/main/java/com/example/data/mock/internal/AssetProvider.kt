package com.example.data.mock.internal

import android.content.res.AssetManager
import java.util.Scanner
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse

@Suppress(
    "MagicNumber",
    "ComplexMethod",
    "NestedBlockDepth",
    "FunctionMaxLength",
    "CommentOverPrivateFunction"
)
class AssetProvider(
    private val assetManager: AssetManager
) {

    /**
     * Create a [MockResponse] object from a file.
     *
     * @param fileName The name of the file from which to create a [MockResponse]. This must contain
     * the file extension (.json, .txt, etc.)
     * @param statusCode The [StatusCode] to apply to said response. The default value is
     * [StatusCode.OK]
     * @param delayInMs The delay with which to return the body of the [MockResponse]
     */
    fun createResponseFromAssets(
        fileName: String,
        statusCode: Int = 200,
        delayInMs: Long = DEFAULT_DELAY_IN_MS
    ): MockResponse {
        val inputStream = assetManager.open(fileName)

        val s = Scanner(inputStream, Charsets.UTF_8.name()).useDelimiter("\\A")
        val result = if (s.hasNext()) s.next() else ""

        return MockResponse()
            .setBody(result)
            .setResponseCode(statusCode)
            .setBodyDelay(delayInMs, TimeUnit.MILLISECONDS)
    }

    /**
     * Create an empty [MockResponse].
     *
     * @param statusCode The [StatusCode] to apply to said response. The default value is
     * [StatusCode.OK]
     * @param delayInMs The delay with which to return the body of the [MockResponse]
     */
    fun createEmptyResponse(
        statusCode: Int = 200,
        delayInMs: Long = DEFAULT_DELAY_IN_MS
    ): MockResponse =
        MockResponse()
            .setBody("")
            .setResponseCode(statusCode)
            .setHeadersDelay(delayInMs, TimeUnit.MILLISECONDS)

    companion object {
        private const val DEFAULT_DELAY_IN_MS = 1_000L
    }
}
