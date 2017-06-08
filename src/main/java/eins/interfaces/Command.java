package eins.interfaces;

import eins.exceptions.SMDBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void execute(HttpServletRequest request)
            throws SMDBException;
}
