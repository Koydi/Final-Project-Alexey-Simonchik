package by.epam.tc.dao.factory;

import by.epam.tc.dao.impl.UserDataBaseDAO;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    private static UserDataBaseDAO userDataBaseDAO = new UserDataBaseDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDataBaseDAO getUserDataBaseDAO() {
        return userDataBaseDAO;
    }
}
