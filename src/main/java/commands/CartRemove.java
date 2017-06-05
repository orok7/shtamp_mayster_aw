package commands;

import exceptions.SMDBException;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartRemove implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SMDBException {
        
    }
}
