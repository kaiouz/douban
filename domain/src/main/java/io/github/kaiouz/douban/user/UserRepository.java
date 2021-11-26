package io.github.kaiouz.douban.user;

public interface UserRepository {

    User byId(String id);

    String save(User user);

}
