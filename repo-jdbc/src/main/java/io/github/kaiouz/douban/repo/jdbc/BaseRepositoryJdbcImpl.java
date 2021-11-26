package io.github.kaiouz.douban.repo.jdbc;

import javax.sql.DataSource;
import java.sql.*;

public class BaseRepositoryJdbcImpl {

    private final DataSource dataSource;

    public BaseRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected <T> T doInConnection(Function<Connection, T> function) {
        try {
            Connection conn = dataSource.getConnection();

            try {
                conn.setAutoCommit(false);

                T rs = function.apply(conn);

                conn.commit();

                return rs;
            } catch (Throwable e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    protected <T> T select(Connection conn, String sql,
                           Consumer<PreparedStatement> consumer,
                           Function<ResultSet, T> function) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            consumer.accept(statement);
            ResultSet resultSet = statement.executeQuery();
            return function.apply(resultSet);
        }
    }

    protected <T> T insert(Connection conn, String sql,
                           Consumer<PreparedStatement> consumer,
                           BiFunction<ResultSet, Integer, T> function) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            consumer.accept(statement);
            int rs = statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return function.apply(resultSet, rs);
                } else {
                    return null;
                }
            }
        }
    }

    protected int delete(Connection conn, String sql, Consumer<PreparedStatement> consumer) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            consumer.accept(statement);
            return statement.executeUpdate();
        }
    }


    protected int update(Connection conn, String sql, Consumer<PreparedStatement> consumer) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            consumer.accept(statement);
            return statement.executeUpdate();
        }
    }

    public interface Consumer<T> {
        void accept(T t) throws SQLException;
    }

    public interface Function<T, R> {
        R apply(T t) throws SQLException;
    }

    public interface BiFunction<T, U, R> {
        R apply(T t, U u) throws SQLException;
    }
}
