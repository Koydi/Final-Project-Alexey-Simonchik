package by.epam.tc.service.factory;

import by.epam.tc.service.IUserService;
import by.epam.tc.service.impl.UserService;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private UserService userService = new UserService();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public IUserService getUserService() {
        return userService;
    }
}
