package eins.service.impl;

import eins.dao.CompanyUserDAO;
import eins.dao.ContactsDAO;
import eins.dao.IndividualUserDAO;
import eins.dao.UserDAO;
import eins.entity.CompanyUser;
import eins.entity.Contacts;
import eins.entity.IndividualUser;
import eins.entity.User;
import eins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO uDAO;
    @Autowired
    private CompanyUserDAO cuDAO;
    @Autowired
    private IndividualUserDAO iuDAO;
    @Autowired
    private ContactsDAO cDAO;

    @Override
    public void save(String userEmail, String userPassword,
                     String userName, String userSurname) {

        IndividualUser iu = new IndividualUser(0, userName, userSurname);
        Contacts contacts = new Contacts(userName, userSurname);
        iuDAO.save(iu);
        cDAO.save(contacts);
        uDAO.save(new User(userEmail, userPassword, false, null, iu, contacts));

    }

    @Override
    public void save(String userEmail, String userPassword, String userOwnership,
                     String userFullName, String userShortName, String userCode,
                     String userContactName, String userContactSurname) {

        if (uDAO.findByLogin(userEmail) != null) return;
        CompanyUser cu = new CompanyUser(0, userOwnership, userFullName, userShortName, userCode);
        Contacts contacts = new Contacts(userContactName, userContactSurname);
        cuDAO.save(cu);
        cDAO.save(contacts);
        uDAO.save(new User(userEmail, userPassword, true, cu, null, contacts));

    }

    @Override
    public User findOne(int id) {
        return uDAO.findOne(id);
    }

    @Override
    public User findByLogin(String login) {
        return uDAO.findByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return uDAO.findAll();
    }

    @Override
    public void setTempPassword(int userId, String tempPassword) {
        User user = uDAO.findOne(userId);
        if (user != null) user.setTempPassword(tempPassword);
    }

    @Override
    public void clearTempPassword(int userId) {
        User user = uDAO.findOne(userId);
        if (user != null) user.setTempPassword(null);
    }
}
