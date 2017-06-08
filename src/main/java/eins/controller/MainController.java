package eins.controller;

import eins.dao.interfaces.CompanyUserDAO;
import eins.dao.interfaces.ContactsDAO;
import eins.dao.interfaces.IndividualUserDAO;
import eins.dao.interfaces.UserDAO;
import eins.entity.CompanyUser;
import eins.entity.Contacts;
import eins.entity.IndividualUser;
import eins.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    int pageNum = 1;
    int inPage = 8;
    int elemNum = 100;
    List<String> list = new ArrayList<String>();
    {
        for (int i = 1; i < elemNum+1; i++)
            list.add("Content " + i);
    }

    //    @RequestMapping(method = RequestMethod.GET, value = "/")
    @GetMapping({"/","/nextPage","/prevPage","/toFirstPage","/toLastPage"})
    public String index(HttpServletRequest request) {
        makeContent(request);
        return "index";
    }

    @PostMapping("/registration")
    public String saveBlog(HttpServletRequest request){

        String isCompanyStr = request.getParameter("isCompany");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userPassAgain = request.getParameter("userPassAgain");
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String userForm = request.getParameter("userForm");
        String userFullName = request.getParameter("userFullName");
        String userShortName = request.getParameter("userShortName");
        String userCode = request.getParameter("userCode");
        String userContactName = request.getParameter("userContactName");
        String userContactSurname = request.getParameter("userContactSurname");

        System.out.println(isCompanyStr + " " +
                userEmail + " " +
                userPassword + " " +
                userName + " " +
                userSurname
        );

        boolean isCompany = (isCompanyStr == null)?false:true;
        System.out.println(1);

        User user;
        if (isCompany) {
            System.out.println(2);
            CompanyUser cu = new CompanyUser(0,userForm,userFullName,userShortName,userCode);
            System.out.println(3);
            Contacts contacts = new Contacts(userContactName,userContactSurname);
            System.out.println(4);
            user = new User(userEmail,userPassword,isCompany,cu,null, contacts);
            System.out.println(5);
//            companyUserDAO.save(cu);
//            System.out.println(6);
//            contactsDAO.save(contacts);
//            System.out.println(7);
//            userDAO.save(user);
        } else {
            System.out.println(8);
            IndividualUser iu = new IndividualUser(0, userName, userSurname);
            System.out.println(iu);
            System.out.println(9);
            Contacts contacts = new Contacts(userName, userSurname);
            System.out.println(contacts);
            System.out.println(10);
            user = new User(userEmail, userPassword, isCompany, null, iu, contacts);
            System.out.println(11);
            new eins.dao.impl.IndividualUserDAOImpl().save(iu);
            System.out.println(12);
//            contactsDAO.save(contacts);
//            System.out.println(13);
//            userDAO.save(user);
        }
        makeContent(request);
//        Command cmd = new AccountCreateNew();
//        try {
//            cmd.execute(request);
//        } catch (SMDBException e) {
//            e.printStackTrace();
//        }
        return "index";
    }

    void makeContent(HttpServletRequest request){
        request.setAttribute("title", "Index page");
        request.setAttribute("contentTitle", "Печатки для ФОП");
        switch (request.getRequestURI()){
            case "/toFirstPage":
                if (pageNum > 1) pageNum = 1;
                break;
            case "/prevPage":
                if (pageNum > 1) pageNum--;
                break;
            case "/nextPage":
                if (pageNum * inPage < list.size()) pageNum++;
                break;
            case "/toLastPage":
                if (pageNum * inPage < list.size())
                    pageNum = (int)Math.ceil((double)list.size() / inPage);
                break;
        }

        boolean lastPage = inPage*pageNum >= list.size();

        request.setAttribute("pageNum", pageNum);
        request.setAttribute("lastPage", lastPage);

        List<String> listOut = list.subList(
                inPage*(pageNum-1),
                (inPage*(pageNum-1)+inPage) > list.size()
                        ?list.size():(inPage*(pageNum-1)+inPage));
        request.setAttribute("list", listOut );
    }
}