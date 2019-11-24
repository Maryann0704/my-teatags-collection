package dao;

import pojo.Trademark;
import connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class TrademarkDao extends AbstractDao<Trademark> {
    @Override
    public boolean create(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `trademark`(`trademark`) VALUES ('%s')",
                trademark.getTrademark());
        long id = executeCreate(sql);
        if (id > 0)
            trademark.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `trademark` SET `trademark`='%s' WHERE `id`=%d",
                trademark.getTrademark(), trademark.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `trademark` WHERE `id`=%d",
                trademark.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Trademark> getAll(String where) throws SQLException {
        List<Trademark> trademarks = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `trademark` %s", where);
        try (
                Connection connection = ConnectionCreator.getConnectionPool();
                Statement statement = Objects.requireNonNull(connection).createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Trademark trademark = new Trademark(
                        resultSet.getLong("id"),
                        resultSet.getString("trademark"));
                trademarks.add(trademark);
            }
        }
        return trademarks;
    }

    @Override
    public List<Trademark> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Trademark read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Trademark> trademarks = getAll(where);
        if (trademarks.size() == 1)
            return trademarks.get(0);
        else
            return null;
    }
}
