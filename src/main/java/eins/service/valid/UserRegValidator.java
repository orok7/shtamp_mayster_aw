package eins.service.valid;

import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegValidator implements Validator {

    @Autowired
    private UserService uService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

       /* User user = (User) target;

        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            errors.rejectValue("login", "450","Необхідно вказати Email");
            return;
        }

        User fUser = uService.findByLogin( user.getLogin() );

        if (fUser != null) {
            errors.rejectValue("login", "450","Вказаний Email вже зареєстровано");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()
                || user.getTempPassword() == null || user.getTempPassword().isEmpty()){
            errors.rejectValue("password", "450","Необхідно вказати пароль та його підтвердити");
        } else if (!user.getPassword().equals(user.getTempPassword())) {
            errors.rejectValue("password", "450","Помилка підтвердження паролю");
        }*/

    }
}
