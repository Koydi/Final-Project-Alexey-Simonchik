package by.epam.tc.listener;

import by.epam.tc.dao.connection_pool.ConnectionPool;
import by.epam.tc.dao.connection_pool.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool connectionPool;
            connectionPool = ConnectionPool.getInstance();
            connectionPool.init();
        } catch (ConnectionPoolException exception) {
            exception.printStackTrace();
            throw new RuntimeException("JDBC error", exception);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool connectionPool;
            connectionPool = ConnectionPool.getInstance();
            connectionPool.destroy();
        } catch (ConnectionPoolException exception) {
            exception.printStackTrace();
            throw new RuntimeException("JDBC error", exception);
        }
    }
}
