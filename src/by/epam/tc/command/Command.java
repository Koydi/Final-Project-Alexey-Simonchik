package by.epam.tc.command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException;
}