//package eins.commands;
//
//import eins.dao.interfaces.CompanyUserDAO;
//import eins.dao.interfaces.ContactsDAO;
//import eins.dao.interfaces.IndividualUserDAO;
//import eins.dao.interfaces.UserDAO;
//import eins.entity.*;
//import eins.exceptions.SMDBException;
//import eins.interfaces.Command;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import javax.servlet.http.HttpServletRequest;
//
//public class AccountCreateNew implements Command {
//
//    @Autowired
//    @Qualifier("iuDAO1")
//    private IndividualUserDAO iuDAO;
//    @Autowired
//    @Qualifier("cuDAO1")
//    private CompanyUserDAO cuDAO;
//    @Autowired
//    @Qualifier("cDAO1")
//    private ContactsDAO cDAO;
//    @Autowired
//    @Qualifier("uDAO1")
//    private UserDAO uDAO;
//
//    @Override
//    public void execute(HttpServletRequest request) throws SMDBException {
//        String isCompanyStr = request.getParameter("isCompany");
//        String userEmail = request.getParameter("userEmail");
//        String userPassword = request.getParameter("userPassword");
//        String userPassAgain = request.getParameter("userPassAgain");
//        String userName = request.getParameter("userName");
//        String userSurname = request.getParameter("userSurname");
//        String userForm = request.getParameter("userForm");
//        String userFullName = request.getParameter("userFullName");
//        String userShortName = request.getParameter("userShortName");
//        String userCode = request.getParameter("userCode");
//        String userContactName = request.getParameter("userContactName");
//        String userContactSurname = request.getParameter("userContactSurname");
//        System.out.println(isCompanyStr + " " +
//                userEmail + " " +
//                userPassword + " " +
//                userName + " " +
//                userSurname
//        );
//
//        boolean isCompany = (isCompanyStr == null)?false:true;
//        User user;
//
//        if (isCompany) {
//            CompanyUser cu = new CompanyUser(0,userForm,userFullName,userShortName,userCode);
//            Contacts contacts = new Contacts(userContactName,userContactSurname);
//            user = new User(userEmail,userPassword,isCompany,cu,null, contacts);
//            try {
//                cuDAO.save(cu);
//                cDAO.save(contacts);
//                uDAO.save(user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            IndividualUser iu = new IndividualUser(0, userName, userSurname);
//            Contacts contacts = new Contacts(userName, userSurname);
//            user = new User(userEmail, userPassword, isCompany, null, iu, contacts);
//            try {
//                iuDAO.save(iu);
//                cDAO.save(contacts);
//                uDAO.save(user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
