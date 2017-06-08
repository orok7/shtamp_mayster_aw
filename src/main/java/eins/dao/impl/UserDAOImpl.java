package eins.dao.impl;

import eins.dao.interfaces.UserDAO;
import eins.entity.CompanyUser;
import eins.entity.Contacts;
import eins.entity.IndividualUser;
import eins.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("uDAO1")
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
    public void saveCompletely(String isCompanyStr,
                               String userEmail,
                               String userPassword,
                               String userName,
                               String userSurname,
                               String userForm,
                               String userFullName,
                               String userShortName,
                               String userCode,
                               String userContactName,
                               String userContactSurname) {

        boolean isCompany = (isCompanyStr == null)?false:true;
        User user;

        if (isCompany) {
            CompanyUser cu = new CompanyUser(0,userForm,userFullName,userShortName,userCode);
            Contacts contacts = new Contacts(userContactName,userContactSurname);
            user = new User(userEmail,userPassword,isCompany,cu,null, contacts);
            manager.persist(cu);
            manager.persist(contacts);
            manager.persist(user);
        } else {
            IndividualUser iu = new IndividualUser(0, userName, userSurname);
            Contacts contacts = new Contacts(userName, userSurname);
            user = new User(userEmail, userPassword, isCompany, null, iu, contacts);
            manager.persist(iu);
            manager.persist(contacts);
            manager.persist(user);
        }
    }

    @Override
    public User findById(int id) {
        return manager.find(User.class,id);
    }

    @Override
    public User findByLogin(String userEmail) {
        List<User> userList = manager.createQuery("from User u where u.login like :uE", User.class)
                .setParameter("uE", userEmail)
                .getResultList();
        if (userList.size() == 1) return userList.get(0);
        return null;
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("from User u", User.class).getResultList();
    }
}
