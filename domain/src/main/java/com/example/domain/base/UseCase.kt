package com.example.domain.base

import com.example.domain.usecase.Result

abstract class UseCase<in Parameters, Success, Error> {


    @Suppress("TooGenericExceptionCaught")
    suspend operator fun invoke(parameters: Parameters): Result<Success, Error> {
        return execute(parameters)
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: Parameters): Result<Success, Error>
}