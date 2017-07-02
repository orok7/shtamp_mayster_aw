package eins.service.interfaces;

import eins.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {

    void save(String userEmail, String userPassword,
              String userName, String userSurname);

    void save(String userEmail, String userPassword, String userOwnership,
              String userFullName, String userShortName, String userCode,
              String userContactName, String userContactSurname);

    User findOne(int id);

    User findByUsername(String username);

    List<User> findAll();

    void setTempPassword(int userId, String tempPassword);

    void clearTempPassword(int userId);

    boolean userCheckPass(User user, String pass);

    boolean userTempPassIsValid(User user);
}
