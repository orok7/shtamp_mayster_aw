package commands;

import exceptions.SMDBException;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountExit implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SMDBException {
        
    }
}
