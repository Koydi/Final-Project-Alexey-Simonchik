package by.epam.tc.controller;

import by.epam.tc.command.Command;
import by.epam.tc.command.impl.user.*;

import java.util.HashMap;

class CommandProvider {
    private HashMap<Commands, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put(Commands.FIND_PRODUCT, new FindProductCommand());
        commands.put(Commands.SIGN_IN, new SignInCommand());
        commands.put(Commands.SIGN_OUT, new SignOutCommand());
        commands.put(Commands.REGISTRATION, new RegistrationCommand());
        commands.put(Commands.FIND_TOP_PRODUCT, new FindTopProductsCommand());
        commands.put(Commands.GO_TO_REGISTRATION, new GoToRegistrationCommand());
    }

    Command getCommand(String commandName) {
        Commands currentCommand;
        currentCommand = Commands.valueOf(commandName);

        Command command;
        command = commands.get(currentCommand);
        return command;
    }
}
