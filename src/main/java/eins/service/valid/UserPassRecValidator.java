package eins.service.valid;

import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserPassRecValidator implements Validator {

    @Autowired
    private UserService uService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /*User user = (User) target;
        User fUser = uService.findByLogin( user.getLogin() );
        if (fUser == null) {
            errors.rejectValue("login", "450","Невірний email");
        }*/

    }
}
