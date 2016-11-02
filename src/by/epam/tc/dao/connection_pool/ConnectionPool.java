package by.epam.tc.dao.connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final static ConnectionPool instance = new ConnectionPool();
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private final String URL = "jdbc:mysql://localhost:3306/films?useSSL=false";
    private static int NUMBER_CONNECTIONS = 5;

    private BlockingQueue<Connection> connections;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public void init() throws ConnectionPoolException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Problem with connection to JDBC");
        }
        connections = new ArrayBlockingQueue<>(NUMBER_CONNECTIONS);
        for (int i = 0; i < NUMBER_CONNECTIONS; i++) {
            Connection connection;
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new ConnectionPoolException("Problem with establishing connection");
            }
            connections.add(connection);
        }
    }

    public void destroy() throws ConnectionPoolException {
        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionPoolException("Problems with closing connection");
            }
        }
    }

    public Connection takeConnection() {
        Connection connection = null;
        try {
            connection = connections.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void putConnection(Connection connection) {
        connections.add(connection);
    }

}
