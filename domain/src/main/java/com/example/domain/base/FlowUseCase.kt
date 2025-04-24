package com.example.domain.base

import com.example.domain.usecase.Result
import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in Parameters, Success, Error> {

    operator fun invoke(parameters: Parameters): Flow<Result<Success, Error>> {
        return execute(parameters)
    }

    abstract fun execute(parameters: Parameters): Flow<Result<Success, Error>>
}