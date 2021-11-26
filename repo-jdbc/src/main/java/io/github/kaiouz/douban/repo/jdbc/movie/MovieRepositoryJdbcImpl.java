package io.github.kaiouz.douban.repo.jdbc.movie;

import io.github.kaiouz.douban.movie.Movie;
import io.github.kaiouz.douban.movie.MovieRepository;

public class MovieRepositoryJdbcImpl implements MovieRepository  {

    @Override
    public Movie byId(int id) {
        return null;
    }

    @Override
    public int save(Movie movie) {
        return 0;
    }

}
