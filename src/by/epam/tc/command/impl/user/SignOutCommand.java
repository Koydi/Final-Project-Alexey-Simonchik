package by.epam.tc.command.impl.user;

import by.epam.tc.command.Command;
import by.epam.tc.service.IUserService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;
import com.sun.xml.internal.ws.server.ServerRtException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutCommand implements Command {

    private static String REFERRER = "referer";

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IUserService userService = serviceFactory.getUserService();

        try {
            HttpSession httpSession = httpRequest.getSession(false);
            userService.signOut(httpSession);
            httpResponse.sendRedirect(httpRequest.getHeader(REFERRER));
        } catch (ServiceException exception) {
           //TODO: перевод на страницу ошибки
        }
    }
}
