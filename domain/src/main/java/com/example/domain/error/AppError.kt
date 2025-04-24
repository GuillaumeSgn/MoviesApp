package com.example.domain.error

/**
 * App error class that serves as a container for different error types.
 */
sealed class AppError {

    /**
     * A simple error represented by a [String].
     *
     * @property message The message of the error
     * @property messageRes The string ID of the error
     */
    data class TextualError(
        val message: String? = null,
        val messageRes: Int? = null
    ) : AppError()

    /**
     * A common error represented by a [CommonErrorCode].
     *
     * @property code The [CommonErrorCode] for the error
     */
    data class CommonError(
        val code: CommonErrorCode,
        val originalException: Throwable
    ) : AppError() {

        @Suppress("StringTemplate")
        fun toPrintableCode() = "$ERROR_CODE_PREFIX-${code.code}".plus(originalException.message)

        companion object {
            const val ERROR_CODE_PREFIX = 1
        }
    }

}



