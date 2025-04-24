package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.domain.error.AppError

sealed class Result<out R, out E> {

    data class Success<out T>(val data: T) : Result<T, Nothing>()
    data class Error(val error: AppError) : Result<Nothing, Nothing>()
    data class BusinessRuleError<out E>(val error: E) : Result<Nothing, E>()
    object Loading : Result<Nothing, Nothing>()

    fun isSuccessful() = this is Success
    fun hasFailed() = this is Error
    fun isLoading() = this is Loading

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is BusinessRuleError -> "BusinessRuleError[error=$error]"
            Loading -> "Loading"
        }
    }
}

/**
 * [Success.data][Result.Success.data] if [Result] is of type [Success][Result.Success]
 */
fun <T> Result<T, *>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

inline fun <T> Result<T, *>.onSuccess(block: (T) -> Unit): Result<T, *> {
    if (this is Result.Success<T>) {
        block(data)
    }

    return this
}

inline fun <T> Result<T, *>.onError(block: (AppError) -> Unit): Result<T, *> {
    if (this is Result.Error) {
        block(error)
    }

    return this
}

inline fun <T, E> Result<T, E>.onBusinessRuleError(block: (E) -> Unit): Result<T, E> {
    if (this is Result.BusinessRuleError<E>) {
        block(error)
    }

    return this
}

inline fun <T> Result<T, *>.whenFinished(block: () -> Unit): Result<T, *> {
    block()
    return this
}

val <T> Result<T, *>.data: T?
    get() = (this as? Result.Success)?.data

/**
 * Updates value of [liveData] if [Result] is of query [Success]
 */
inline fun <reified T> Result<T, *>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is Result.Success) {
        liveData.value = data
    }
}