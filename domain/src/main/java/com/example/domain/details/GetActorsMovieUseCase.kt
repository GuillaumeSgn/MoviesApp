package com.example.domain.details

import com.example.domain.base.FlowUseCase
import com.example.domain.model.MovieCredits
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetActorsMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : FlowUseCase<Int, MovieCredits, Nothing>() {
    override fun execute(parameters: Int): Flow<Result<MovieCredits, Nothing>> {
        return flow {
            emit(Result.Success(movieRepository.getActorsOfMovie(parameters)))
        }
    }


}