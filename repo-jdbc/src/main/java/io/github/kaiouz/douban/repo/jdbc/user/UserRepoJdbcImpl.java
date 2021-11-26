package io.github.kaiouz.douban.repo.jdbc.user;

import io.github.kaiouz.douban.repo.jdbc.BaseRepositoryJdbcImpl;
import io.github.kaiouz.douban.user.User;
import io.github.kaiouz.douban.user.UserRepository;

import javax.sql.DataSource;


public class UserRepoJdbcImpl extends BaseRepositoryJdbcImpl implements UserRepository {

    public UserRepoJdbcImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public User byId(String id) {
        return doInConnection(conn -> {
            return select(conn, "select id, nickname from user where id = ?",
                    stat -> {
                        stat.setString(1, id);
                    },
                    rs -> {
                        if (rs.next()) {
                            String userId = rs.getString(1);
                            String nickname = rs.getString(2);
                            return new User(userId, nickname);
                        } else {
                            return null;
                        }
                    });
        });
    }

    @Override
    public String save(User user) {
        return doInConnection(conn -> {
            return insert(conn, "insert into user (id, nickname) values (?, ?)",
                    stat -> {
                        stat.setString(1, user.getId());
                        stat.setString(2, user.getNickname());
                    },
                    (rs, count) -> {
                        return rs.getString(1);
                    });
        });
    }

}
