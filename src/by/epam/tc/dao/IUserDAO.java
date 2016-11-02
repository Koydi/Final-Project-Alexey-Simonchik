package by.epam.tc.dao;

import by.epam.tc.bean.Product;
import by.epam.tc.bean.entity.User;
import by.epam.tc.dao.exception.DAOException;

public interface IUserDAO {
    Product findProduct(String productName) throws DAOException;
    User addUser(String userEmail, String userPassword) throws DAOException;
    User getUser(String userEmail, String userPassword) throws DAOException;

}