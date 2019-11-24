package dao;

import pojo.Role;
import connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class RoleDao extends AbstractDao<Role> {
    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        long id = executeCreate(sql);
        if (id >0)
            role.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `roles` SET `role`='%s' WHERE `id`=%d",
                role.getRole(), role.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `roles` %s", where);
        try (Connection connection = ConnectionCreator.getConnectionPool();
             Statement statement = Objects.requireNonNull(connection).createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Role role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
                roles.add(role);
            }
        }
        return roles;
    }

    @Override
    public Role read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Role> roles = getAll(where);
        if (roles.size() == 1)
            return roles.get(0);
        else
            return null;
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }
}
