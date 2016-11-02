package by.epam.tc.command.impl.user;

import by.epam.tc.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationCommand implements Command {

    private static String PATH = "WEB-INF/jsp/registration.jsp";

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        httpRequest.getRequestDispatcher(PATH).forward(httpRequest, httpResponse);
    }
}
