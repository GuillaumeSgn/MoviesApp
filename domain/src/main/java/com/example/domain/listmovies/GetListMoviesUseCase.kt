package com.example.domain.listmovies

import com.example.domain.base.FlowUseCase
import com.example.domain.model.Movies
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetListMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : FlowUseCase<Unit, Map<MovieListType, List<Movies>>, Nothing>() {
    override fun execute(parameters: Unit): Flow<Result<Map<MovieListType, List<Movies>>, Nothing>> {
        return flow {
            emit(Result.Loading)
            val popularMovies = movieRepository.getListPopular().results
            val upcomingMovies = movieRepository.getListUpcoming().results
            val topRatedMovies = movieRepository.getListTopRated().results
            val nowPlayingMovies = movieRepository.getListNowPlaying().results

            val movieLists = mapOf(
                MovieListType.POPULAR to popularMovies,
                MovieListType.UPCOMING to upcomingMovies,
                MovieListType.TOP_RATED to topRatedMovies,
                MovieListType.NOW_PLAYING to nowPlayingMovies
            )

            emit(Result.Success(movieLists))
        }
    }
}