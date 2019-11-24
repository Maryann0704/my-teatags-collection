package connect;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private ConnectionCreator() {
    }
    private static Connection connection;

    public static Connection getConnectionPool() {
        Connection connection = null;

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/my_collection");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionCreator.class) {
                if (connection == null || connection.isClosed()) {
                    connection= DriverManager.getConnection(
                            SetupConnection.URL,
                            SetupConnection.USER,
                            SetupConnection.PASSWORD);
                }
            }
        }
        return connection;
    }
}
