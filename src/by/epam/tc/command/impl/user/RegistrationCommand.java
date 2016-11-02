package by.epam.tc.command.impl.user;

import by.epam.tc.bean.entity.User;
import by.epam.tc.command.Command;
import by.epam.tc.service.IUserService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static String PATH = "/film?command=FIND_PRODUCT&name=Avatar";
    private static String USER_EMAIL = "email";
    private static String USER_PASSWORD = "password";
    private static String SESSION_USER_ATTRIBUTE = "user";

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        String userEmail = httpRequest.getParameter(USER_EMAIL);
        String userPassword = httpRequest.getParameter(USER_PASSWORD);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IUserService userService = serviceFactory.getUserService();

        try {
            User user = userService.registration(userEmail, userPassword);
            userService.signIn(userEmail, userPassword);
            HttpSession httpSession = httpRequest.getSession(true);
            httpSession.setAttribute(SESSION_USER_ATTRIBUTE, userEmail);
            httpResponse.sendRedirect(PATH);
        } catch (ServiceException exception) {
            //TODO: перевод на страницу ошибки
        }
    }
}
