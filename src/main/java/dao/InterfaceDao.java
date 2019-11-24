package dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<T> {

    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;

    List<T> getAll(String where) throws SQLException;
    List<T> getAll() throws SQLException;

    T read(long id) throws SQLException;
}
