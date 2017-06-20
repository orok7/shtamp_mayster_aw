package eins.service.edit;

import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class UserLoginEditor extends PropertyEditorSupport{

    @Autowired
    private UserService uService;

    @Override
    public void setAsText(String login) throws IllegalArgumentException {
        System.out.println("Editor ->");
    }
}
