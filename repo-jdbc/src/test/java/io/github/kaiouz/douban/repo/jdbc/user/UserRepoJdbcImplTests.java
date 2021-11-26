package io.github.kaiouz.douban.repo.jdbc.user;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.kaiouz.douban.user.User;
import io.github.kaiouz.douban.user.UserRepository;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepoJdbcImplTests {

    UserRepository userRepository;

    HikariDataSource hikariDataSource;

    @BeforeAll
    public void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:douban;DB_CLOSE_DELAY=-1;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;INIT=runscript from 'classpath:init.sql'");
        config.setUsername("sa");
        config.setPassword("sa");
        hikariDataSource = new HikariDataSource(config);

        userRepository = new UserRepoJdbcImpl(hikariDataSource);
    }

    @Test
    @Order(1)
    public void saveTest() {
        User user = new User("1", "1");
        String id = userRepository.save(user);
        Assertions.assertEquals(user.getId(), id);
    }

    @Test
    @Order(2)
    public void getTest() {
       User user =  userRepository.byId("1");
       Assertions.assertEquals("1", user.getId());
       Assertions.assertEquals("1", user.getId());
    }

    @AfterAll
    public void destroy() {
        hikariDataSource.close();
    }
}
