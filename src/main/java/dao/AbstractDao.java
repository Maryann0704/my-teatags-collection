package dao;

import connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public abstract class AbstractDao<T> implements InterfaceDao<T> {

    protected long executeCreate(String sql) throws SQLException {
        System.out.println("DEBUG:"+sql);
        try (Connection connection = ConnectionCreator.getConnectionPool();
             Statement statement = Objects.requireNonNull(connection).createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

    protected boolean executeUpdate(String sql) throws SQLException {
        System.out.println("DEBUG:"+sql);
        try (Connection connection = ConnectionCreator.getConnectionPool();
             Statement statement = Objects.requireNonNull(connection).createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
