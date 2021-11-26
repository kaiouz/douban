package io.github.kaiouz.douban.movie;

public interface MovieRepository {

    Movie byId(int id);

    int save(Movie movie);
}
