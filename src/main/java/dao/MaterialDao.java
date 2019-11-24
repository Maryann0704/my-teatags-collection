package dao;

import connect.ConnectionCreator;
import pojo.Material;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MaterialDao extends AbstractDao<Material> {
    @Override
    public boolean create(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `material`(`material`) VALUES ('%s')",
                material.getMaterial());
        long id = executeCreate(sql);
        if (id > 0)
            material.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `material` SET `material`='%s' WHERE `id`=%d",
                material.getMaterial(), material.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `material` WHERE `id`=%d",
                material.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Material> getAll(String where) throws SQLException {
        List<Material> materials = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `material` %s", where);
        try (
                Connection connection = ConnectionCreator.getConnectionPool();
                Statement statement = Objects.requireNonNull(connection).createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Material material = new Material(
                        resultSet.getLong("id"),
                        resultSet.getString("material"));
                materials.add(material);
            }
        }
        return materials;
    }

    @Override
    public List<Material> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Material read(long id) throws SQLException {
        String where=String.format(" WHERE `id`=%d LIMIT 0,1", id);
        List<Material> materials = getAll(where);
        if (materials.size() == 1)
            return materials.get(0);
        else
            return null;
    }
}
