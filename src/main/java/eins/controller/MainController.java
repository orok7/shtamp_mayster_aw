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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    @Qualifier("iuDAO1")
    private IndividualUserDAO iuDAO;
    @Autowired
    @Qualifier("cuDAO1")
    private CompanyUserDAO cuDAO;
    @Autowired
    @Qualifier("cDAO1")
    private ContactsDAO cDAO;
    @Autowired
    @Qualifier("uDAO1")
    private UserDAO uDAO;

    int pageNum = 1;
    int inPage = 8;
    int elemNum = 100;
    List<String> list;

    @GetMapping({"/","/nextPage","/prevPage","/toFirstPage","/toLastPage"})
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
            int loggedUserId,
            Model model, HttpServletRequest r) {
        System.out.println("index.jsp");
        if (loggedUserId != -1) {
            model.addAttribute("loggedDisplay", "block");
            model.addAttribute("loginDisplay", "none");
            User user = uDAO.findById(loggedUserId);
            if (!user.isCompany())
                model.addAttribute("luName", "mr. " + user.getIndividualDate().getName() +
                        " " + user.getIndividualDate().getSurname());
            else model.addAttribute("luName", "your company " + user.getCompanyDate().getShortName());
        } else {
            model.addAttribute("loggedDisplay", "none");
            model.addAttribute("loginDisplay", "block");
            System.out.println("Nobody logged");
        }
        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/registration")
    public String saveUser(@RequestParam(value = "isCompany", required = false) String isCompanyStr,
                           @RequestParam("userEmail") String userEmail,
                           @RequestParam("userPassword") String userPassword,
                           @RequestParam("userPassAgain") String userPassAgain,
                           @RequestParam("userName") String userName,
                           @RequestParam("userSurname") String userSurname,
                           @RequestParam("userForm") String userForm,
                           @RequestParam("userFullName") String userFullName,
                           @RequestParam("userShortName") String userShortName,
                           @RequestParam("userCode") String userCode,
                           @RequestParam("userContactName") String userContactName,
                           @RequestParam("userContactSurname") String userContactSurname,
                           Model model, HttpServletRequest r){

        boolean isAnyEmpty = isRDAnyEmpty(r);
        if (isAnyEmpty || !userPassAgain.equals(userPassword)
                || uDAO.findByLogin(userEmail) != null) {
            model.addAttribute("regModDisplay","block");
            model.addAttribute("userEmail", userEmail);
            model.addAttribute("userName", userName);
            model.addAttribute("userSurname", userSurname);
            model.addAttribute("userForm", userForm);
            model.addAttribute("userFullName", userFullName);
            model.addAttribute("userShortName", userShortName);
            model.addAttribute("userCode", userCode);
            model.addAttribute("userContactName", userContactName);
            model.addAttribute("userContactSurname", userContactSurname);
            if (isAnyEmpty)
                model.addAttribute("msgWWR", "Необхідно ввести всі дані");
            else if(!userPassAgain.equals(userPassword))
                model.addAttribute("msgWWR", "Не вірне підтвердження паролю");
                else model.addAttribute("msgWWR", "Такий е-mail вже зареєстровано");
        } else {
            uDAO.saveCompletely(isCompanyStr, userEmail, userPassword,
                    userName, userSurname,
                    userForm, userFullName, userShortName, userCode,
                    userContactName, userContactSurname);
        }
        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/passRecovery")
    public String recoveryPassword(@RequestParam("userEmailForRecovery") String userEmailForRecovery,
                                   Model model, HttpServletRequest r){
        User user = uDAO.findByLogin(userEmailForRecovery);
        if (user != null) model.addAttribute("msgWWPR",user.getPassword());
        else model.addAttribute("msgWWPR", "Вказаний e-mail не знайдено");
        model.addAttribute("passRecModDisplay","block");
        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam("loginName") String userEmail,
                        @RequestParam("pass") String userPassword,
                        Model model, HttpServletRequest r, HttpServletResponse res){
        User user = uDAO.findByLogin(userEmail);
        if (user == null || !user.getPassword().equals(userPassword))
            System.out.println("Wrong login or password");
        else {
            res.addCookie(new Cookie("loggedUserId",String.valueOf(user.getId())));
            model.addAttribute("loggedDisplay", "block");
            model.addAttribute("loginDisplay", "none");
            if (!user.isCompany())
                model.addAttribute("luName", "mr. " + user.getIndividualDate().getName() +
                        " " + user.getIndividualDate().getSurname());
            else model.addAttribute("luName", "your company " + user.getCompanyDate().getShortName());
        }
        makeContent(model,r.getRequestURI());
        return "index";
    }

    @PostMapping("/logout")
    public String logOut(Model model, HttpServletRequest r, HttpServletResponse res){
        model.addAttribute("loggedDisplay", "none");
        model.addAttribute("loginDisplay", "block");
        res.addCookie(new Cookie("loggedUserId","-1"));
        makeContent(model,r.getRequestURI());
        return "index";
    }

    /** Is any of registration data empty*/
    private boolean isRDAnyEmpty(HttpServletRequest r){
        String isCompanyStr = r.getParameter("isCompany");
        String userEmail = r.getParameter("userEmail");
        String userPassword = r.getParameter("userPassword");
        String userPassAgain = r.getParameter("userPassAgain");
        String userName = r.getParameter("userName");
        String userSurname = r.getParameter("userSurname");
        String userForm = r.getParameter("userForm");
        String userFullName = r.getParameter("userFullName");
        String userShortName = r.getParameter("userShortName");
        String userCode = r.getParameter("userCode");
        String userContactName = r.getParameter("userContactName");
        String userContactSurname = r.getParameter("userContactSurname");
        boolean isCompany = (isCompanyStr == null)?false:true;
        if (isCompany) {
            if (userEmail.isEmpty() || userPassword.isEmpty() || userPassAgain.isEmpty() ||
                    userForm.isEmpty() || userFullName.isEmpty() || userShortName.isEmpty() ||
                    userCode.isEmpty() || userContactName.isEmpty() || userContactSurname.isEmpty()) {
                return true;
            }
        }else {
            if (userEmail.isEmpty() || userPassword.isEmpty() || userPassAgain.isEmpty() ||
                    userName.isEmpty()||userSurname.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void makeContent(Model model, String uri){

        if (list == null) {
            list = new ArrayList<>();
            for (int i = 1; i < elemNum + 1; i++)
                list.add("Content " + i);
        }

        model.addAttribute("title", "Index page");
        model.addAttribute("contentTitle", "Печатки для ФОП");
        switch (uri){
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

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("lastPage", lastPage);

        List<String> listOut = list.subList(
                inPage*(pageNum-1),
                (inPage*(pageNum-1)+inPage) > list.size()
                        ?list.size():(inPage*(pageNum-1)+inPage));
        model.addAttribute("list", listOut );
    }
}