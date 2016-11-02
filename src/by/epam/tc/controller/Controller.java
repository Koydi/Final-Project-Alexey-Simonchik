package by.epam.tc.controller;

import by.epam.tc.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        String commandName;
        commandName = httpRequest.getParameter("command");

        Command command;
        command = commandProvider.getCommand(commandName);

        command.execute(httpRequest, httpResponse);
    }
}
