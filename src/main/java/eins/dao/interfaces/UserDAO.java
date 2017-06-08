package eins.dao.interfaces;

import eins.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    User findById(int id);

    List<User> findAll();

}
