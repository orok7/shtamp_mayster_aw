//package eins.commands;
//
//import eins.dao.impl.IndividualUserDAOImpl;
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
//    @Qualifier
//    IndividualUserDAOImpl individualUserDAO;
//    @Autowired
//    @Qualifier
//    CompanyUserDAO companyUserDAO;
//    @Autowired
//    @Qualifier
//    UserDAO userDAO;
//    @Autowired
//    @Qualifier
//    ContactsDAO contactsDAO;
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
//        boolean isCompany = (isCompanyStr == null)?false:true;
//        System.out.println(1);
//
//        User user;
//        if (isCompany) {
//            System.out.println(2);
//            CompanyUser cu = new CompanyUser(0,userForm,userFullName,userShortName,userCode);
//            System.out.println(3);
//            Contacts contacts = new Contacts(userContactName,userContactSurname);
//            System.out.println(4);
//            user = new User(userEmail,userPassword,isCompany,cu,null, contacts);
//            System.out.println(5);
//            companyUserDAO.save(cu);
//            System.out.println(6);
//            contactsDAO.save(contacts);
//            System.out.println(7);
//            userDAO.save(user);
//        } else {
//            System.out.println(8);
//            IndividualUser iu = new IndividualUser(0,userName,userSurname);
//            System.out.println(iu);
//            System.out.println(9);
//            Contacts contacts = new Contacts(userName,userSurname);
//            System.out.println(contacts);
//            System.out.println(10);
//            user = new User(userEmail,userPassword,isCompany,null,iu, contacts);
//            System.out.println(11);
//            individualUserDAO.save(iu);
//            System.out.println(12);
//            contactsDAO.save(contacts);
//            System.out.println(13);
//            userDAO.save(user);
//        }
//    }
//}
