package eins.dao.interfaces;

import eins.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    void saveCompletely(String isCompanyStr,
                        String userEmail,
                        String userPassword,
                        String userName,
                        String userSurname,
                        String userForm,
                        String userFullName,
                        String userShortName,
                        String userCode,
                        String userContactName,
                        String userContactSurname);

    User findById(int id);

    User findByLogin(String userEmail);

    List<User> findAll();

}
