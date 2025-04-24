package com.example.domain.details

import com.example.domain.base.FlowUseCase
import com.example.domain.model.MovieDetails
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDetailsMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : FlowUseCase<Int, MovieDetails, Nothing>() {
    override fun execute(parameters: Int): Flow<Result<MovieDetails, Nothing>> {
        return flow {
            emit(Result.Success(movieRepository.findMovieById(parameters)))
        }
    }
}