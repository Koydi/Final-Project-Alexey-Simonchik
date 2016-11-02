package by.epam.tc.service.impl;

import by.epam.tc.bean.Product;
import by.epam.tc.bean.entity.User;
import by.epam.tc.dao.IUserDAO;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.factory.DAOFactory;
import by.epam.tc.service.IUserService;
import by.epam.tc.service.exception.ServiceException;

import javax.servlet.http.HttpSession;

public class UserService implements IUserService {

    private static String SESSION_USER_ATTRIBUTE = "user";

    @Override
    public User signIn(String userEmail, String userPassword) throws ServiceException {

        dataValidation(userEmail, userPassword);

        User user;
        DAOFactory daoFactory = DAOFactory.getInstance();
        IUserDAO userDAO = daoFactory.getUserDataBaseDAO();

        try {
            user = userDAO.getUser(userEmail, userPassword);
        } catch (DAOException exception) {
            throw new ServiceException("No such user or wrong password");
        }
        return user;
    }

    @Override
    public void signOut(HttpSession session) throws ServiceException {
        if (session == null) {
            throw new ServiceException("Session not found");
        }
        session.removeAttribute(SESSION_USER_ATTRIBUTE);
        if (!session.getAttributeNames().hasMoreElements()) {
            session.invalidate();
        }
    }

    @Override
    public User registration(String userEmail, String userPassword) throws ServiceException {

        dataValidation(userEmail, userPassword);
        User user;
        DAOFactory daoFactory = DAOFactory.getInstance();
        IUserDAO userDAO = daoFactory.getUserDataBaseDAO();

        try {
            user = userDAO.addUser(userEmail, userPassword);
        } catch (DAOException exception) {
            throw new ServiceException("No such user or wrong password");
        }
        return user;
    }

    @Override
    public Product findProduct(String productName) throws ServiceException {

        dataValidation(productName);

        Product product;
        DAOFactory daoFactory = DAOFactory.getInstance();
        IUserDAO userDAO = daoFactory.getUserDataBaseDAO();

        try {
            product = userDAO.findProduct(productName);
        } catch (DAOException exception) {
            throw new ServiceException("No such product");
        }

        return product;
    }

    private void dataValidation(String ...data) throws ServiceException {
        for (String temp : data) {
            if (temp == null || temp.isEmpty()) {
                throw new ServiceException("Wrong parameters");
            }
        }
    }
}
