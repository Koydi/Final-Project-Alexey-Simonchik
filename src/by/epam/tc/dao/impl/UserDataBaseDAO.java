package by.epam.tc.dao.impl;

import by.epam.tc.bean.Product;
import by.epam.tc.bean.entity.AgeRestriction;
import by.epam.tc.bean.entity.Film;
import by.epam.tc.bean.entity.User;
import by.epam.tc.dao.IUserDAO;
import by.epam.tc.dao.connection_pool.ConnectionPool;
import by.epam.tc.dao.exception.DAOException;
import com.sun.javafx.binding.StringFormatter;

import java.sql.*;

public class UserDataBaseDAO implements IUserDAO {

    private final static String PRODUCT_SELECT_SQL = "SELECT * FROM film INNER JOIN age_restriction ON film.id=age_restriction.id WHERE film.name=?;";
    private final static String GET_USER_SQL = "SELECT email FROM user WHERE email=? AND password=?;";
    private final static String ADD_USER_SQL = "INSERT INTO user (email, password) VALUES(?, ?);";

    public UserDataBaseDAO() {
    }

    @Override
    public Product findProduct(String productName) throws DAOException {
        Product product = null;
        Connection connection = null;
        System.out.println(productName);
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(PRODUCT_SELECT_SQL);
            preparedStatement.setString(1, productName);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            connectionPool.putConnection(connection);
            product = getProduct(resultSet);
        } catch (SQLException e) {
            System.out.println(e);
            throw new DAOException();
        }
        return product;
    }

    private Product getProduct(ResultSet resultSetFilm) throws DAOException {
        Film result = null;
        AgeRestriction ageRestriction;
        try {
            if (resultSetFilm.next()) {
                result = new Film();
                result.setReleaseDate(resultSetFilm.getString("film.release_year"));
                result.setName(resultSetFilm.getString("film.name"));
                result.setDescription(resultSetFilm.getString("film.description"));
                result.setAverageMark(resultSetFilm.getFloat("film.average_mark"));
                result.setCountry(resultSetFilm.getString("film.country"));
                result.setProducer(resultSetFilm.getString("film.producer"));
                result.setImage(resultSetFilm.getString("film.image"));
                result.setTrailer(resultSetFilm.getString("film.trailer"));
                result.setBudget(resultSetFilm.getString("film.budget"));
                result.setBoxOffice(resultSetFilm.getString("film.box_office"));

                ageRestriction = new AgeRestriction();
                ageRestriction.setDescription(resultSetFilm.getString("age_restriction.description"));
                ageRestriction.setMinimalAge(resultSetFilm.getString("age_restriction.minimum_age"));
                ageRestriction.setName(resultSetFilm.getString("age_restriction.name"));
                result.setAgeRestriction(ageRestriction);
            }
        } catch (SQLException e) {
            throw new DAOException("Product not find");
        }
        return result;
    }

    @Override
    public User getUser(String userEmail, String userPassword) throws DAOException {
        Connection connection = null;
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(GET_USER_SQL);
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            connectionPool.putConnection(connection);
            if (resultSet.next()) {
                user = new User();
                String email = resultSet.getString(1);
                user.setEmail(email);
            }

        } catch (SQLException e) {
            throw new DAOException("No such user");
        }

        return user;
    }

    @Override
    public User addUser(String userEmail, String userPassword) throws DAOException {
        Connection connection = null;
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(ADD_USER_SQL);
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            preparedStatement.execute();
            connectionPool.putConnection(connection);
        } catch (SQLException e) {
            throw new DAOException("Can not add user");
        }
        return user;
    }
}
