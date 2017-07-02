package eins.service.impl;

import eins.dao.CompanyUserDAO;
import eins.dao.UserDAO;
import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final static double TEMP_PASS_TIME_VALID = 5.0;

    @Override
    public void save(String userEmail, String userPassword,
                     String userName, String userSurname) {
/*

        IndividualUser iu = new IndividualUser(0, userName, userSurname);
        Contacts contacts = new Contacts(userName, userSurname);
        iuDAO.save(iu);
        cDAO.save(contacts);
        uDAO.save(new User(userEmail, userPassword, false, null, iu, contacts));
*/

    }

    @Override
    public void save(String userEmail, String userPassword, String userOwnership,
                     String userFullName, String userShortName, String userCode,
                     String userContactName, String userContactSurname) {

        /*if (uDAO.findByLogin(userEmail) != null) return;
        CompanyUser cu = new CompanyUser(0, userOwnership, userFullName, userShortName, userCode);
        Contacts contacts = new Contacts(userContactName, userContactSurname);
        cuDAO.save(cu);
        cDAO.save(contacts);
        uDAO.save(new User(userEmail, userPassword, true, cu, null, contacts));
*/
    }

    @Override
    public User findOne(int id) {
        return uDAO.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return uDAO.findByUsername(username);
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

    @Override
    public boolean userCheckPass(User user, String pass){

        if (user == null) return false;

        if (userTempPassIsValid(user)
                && user.getTempPassword().equals(pass)) return true;

        if (user.getPassword().equals(pass)) return true;

        return false;
    }

    @Override
    public boolean userTempPassIsValid(User user){
        if (user == null || user.getTempPassword() == null) {
            return false;
        }
        double min = (System.currentTimeMillis() - user.getCreateTempPassword().getTime())/60000;
        if (min > TEMP_PASS_TIME_VALID) {
            clearTempPassword(user.getId());
            System.out.println("User id:"+user.getId()+
                    " -> Temp password cleared since expired validity!");
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}
