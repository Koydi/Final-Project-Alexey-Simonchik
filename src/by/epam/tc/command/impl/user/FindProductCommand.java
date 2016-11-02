package by.epam.tc.command.impl.user;

import by.epam.tc.bean.entity.Film;
import by.epam.tc.command.Command;
import by.epam.tc.service.IUserService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindProductCommand implements Command {

    private static String PRODUCT = "name";

    private static String PATH = "WEB-INF/jsp/film_info.jsp";

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        String productName = httpRequest.getParameter(PRODUCT);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IUserService userService = serviceFactory.getUserService();
        try {
            httpResponse.setContentType ("text/html; charset=UTF-8");
            httpResponse.setCharacterEncoding ("UTF-8");
            Film film;
            film = (Film)userService.findProduct(productName);
            httpRequest.setAttribute("film", film);
            httpRequest.getRequestDispatcher(PATH).forward(httpRequest,httpResponse);
        } catch (ServiceException exception) {
            System.out.println(exception);
            //TODO: переход к jsp отображения ошибки
        }
    }
}
