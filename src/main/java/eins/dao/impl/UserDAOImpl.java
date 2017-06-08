package eins.dao.impl;

import eins.dao.interfaces.UserDAO;
import eins.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(User user) {
        if (user != null)
            manager.persist(user);
    }

    @Override
    public User findById(int id) {
        return manager.find(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("from User u", User.class).getResultList();
    }
}
