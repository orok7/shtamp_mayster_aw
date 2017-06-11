package eins.controller;

import eins.dao.CompanyUserDAO;
import eins.dao.ContactsDAO;
import eins.dao.IndividualUserDAO;
import eins.dao.UserDAO;
import eins.entity.User;
import eins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Controller
public class MainController {
    @Autowired
    private UserService uService;

    int pageNum = 1;
    int inPage = 10;
    int elemNum = 100;
    List<String> list;

    final double TEMP_PASS_TIME_VALID = 5.0;

    @GetMapping({"/","/nextPage","/prevPage","/toFirstPage","/toLastPage"})
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
            int loggedUserId,
            Model model, HttpServletRequest r) {

        if (loggedUserId != -1) {
            model.addAttribute("loggedDisplay", "block");
            model.addAttribute("loginDisplay", "none");
            User user = uService.findOne(loggedUserId);
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

    @PostMapping("/regCompanyUser")
    public String regCompanyUser(@RequestParam String userEmail,
                                 @RequestParam String userPassword,
                                 @RequestParam String userOwnership,
                                 @RequestParam String userFullName,
                                 @RequestParam String userShortName,
                                 @RequestParam String userCode,
                                 @RequestParam String userContactName,
                                 @RequestParam String userContactSurname,
                                 Model model, HttpServletRequest r) {

        uService.save(userEmail, userPassword, userOwnership,
                userFullName, userShortName, userCode,
                userContactName, userContactSurname);
        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/regIndividualUser")
    public String regIndividualUser(@RequestParam String userEmail,
                                    @RequestParam String userPassword,
                                    @RequestParam String userName,
                                    @RequestParam String userSurname,
                                    Model model, HttpServletRequest r) {

        uService.save(userEmail, userPassword,
                userName, userSurname);
        makeContent(model, r.getRequestURI());
        return "index";
    }
    
    @GetMapping("/findSameEmail")
    public @ResponseBody String findSameEmail(@RequestParam String userEmail, HttpServletResponse r){
        User user = uService.findByLogin(userEmail);
        if (user == null) return "false";
        return "true";
    }

    @PostMapping("/passRecovery")
    public String recoveryPassword(@RequestParam String userEmailForRecovery,
                                   Model model, HttpServletRequest r){
        User user = uService.findByLogin(userEmailForRecovery);

        if (user != null) {
            if (!userTempPassIsValid(user,TEMP_PASS_TIME_VALID)) {
                uService.setTempPassword(user.getId(), generateTempPass());
                user = uService.findOne(user.getId());
            }
            double min = (System.currentTimeMillis() - user.getCreateTempPassword().getTime())/60000;
            String msg = "Pass: " + user.getTempPassword() + " дійсний ще " + (5.0-min) + " хв.";
            model.addAttribute("msgPlaceInIndex", msg);
        }
        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam String loginName,
                        @RequestParam String pass,
                        Model model, HttpServletRequest r, HttpServletResponse res){

        User user = uService.findByLogin(loginName);
        String msg = "";

        if (user != null) {
            if (user.getTempPassword() != null && !userTempPassIsValid(user, TEMP_PASS_TIME_VALID)) {
                msg += "Temp password cleared since expired validity!   ";
                user = uService.findOne(user.getId());
            }
        }

        if (user == null || !userCheckPass(user, pass)) {

            msg += "Wrong login or password!";

        } else {

            res.addCookie(new Cookie("loggedUserId", String.valueOf(user.getId())));
            model.addAttribute("loggedDisplay", "block");
            model.addAttribute("loginDisplay", "none");
            if (!user.isCompany())
                model.addAttribute("luName", "mr. " + user.getIndividualDate().getName() +
                        " " + user.getIndividualDate().getSurname());
            else model.addAttribute("luName", "your company " + user.getCompanyDate().getShortName());

        }

        System.out.println(msg);
        model.addAttribute("msgPlaceInIndex", msg);
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

    public boolean userTempPassIsValid(User user, double compareThis){
        if (user == null || user.getTempPassword() == null) {
            return false;
        }
        double min = (System.currentTimeMillis() - user.getCreateTempPassword().getTime())/60000;
        if (min > compareThis) {
            uService.clearTempPassword(user.getId());
            return false;
        }
        return true;
    }

    public boolean userCheckPass(User user, String pass){

        if (user == null) return false;

        if (userTempPassIsValid(user,TEMP_PASS_TIME_VALID)
                && user.getTempPassword().equals(pass)) return true;

        if (user.getPassword().equals(pass)) return true;

        return false;
    }

    private String generateTempPass(){
        String pass = "";
        Random r = new Random();
        List<Supplier<Integer>> funcs = new ArrayList<>();
        // number char code [48 - 57]
        funcs.add(() -> {return (r.nextInt(10)+48);});
        // bigger = 65 - 90
        funcs.add(() -> {return (r.nextInt(26)+65);});
        // smaller = 97 - 122
        funcs.add(() -> {return (r.nextInt(26)+97);});
        for (int i = 0; i < 6; i++){
            char ch = (char) (int) funcs.get(r.nextInt(3)).get();
            pass += ch;
        }
        return pass;
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