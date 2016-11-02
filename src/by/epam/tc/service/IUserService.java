package by.epam.tc.service;

import by.epam.tc.bean.Product;
import by.epam.tc.bean.entity.User;
import by.epam.tc.service.exception.ServiceException;

import javax.servlet.http.HttpSession;

public interface IUserService {
    User signIn(String userEmail, String userPassword) throws ServiceException;
    void signOut(HttpSession session) throws ServiceException;
    User registration(String userEmail, String userPassword) throws ServiceException;
    Product findProduct(String productName) throws ServiceException;
}
