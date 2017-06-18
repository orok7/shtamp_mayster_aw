package eins.controller;

import eins.entity.User;
import eins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Controller
public class MainController {
    @Autowired
    private UserService uService;

    /*int pageNum = 1;
    int inPage = 10;
    int elemNum = 100;
    List<String> list;*/

    @ModelAttribute("loggedUser")
    public User post() {
        return new User();
    }

    @GetMapping("/")
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
            int loggedUserId, @RequestParam(required = false) String logoutingModDisplay,
            Model model, HttpServletRequest r) {

        System.out.println(loggedUserId);
        logoutingModDisplay = (logoutingModDisplay==null)?"none":logoutingModDisplay;
        model.addAttribute("logoutingModDisplay", logoutingModDisplay);

        if (loggedUserId != -1) {
            String userName = "";
            User user = uService.findOne(loggedUserId);
            if (user.isCompany()) userName = user.getCompanyDate().getShortName();
            else userName = user.getIndividualDate().getName() + " " + user.getIndividualDate().getSurname();
            model.addAttribute("loggedUserName", userName);
        } else {
            System.out.println("Nobody logged");
        }

        //makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/buildIndex")
    public String buildIndex() {

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
//        makeContent(model, r.getRequestURI());
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
//        makeContent(model, r.getRequestURI());
        return "index";
    }

    @PostMapping("/passRecovery")
    public String recoveryPassword(@RequestParam String userEmailForRecovery,
                                   Model model, HttpServletRequest r){
        User user = uService.findByLogin(userEmailForRecovery);

        if (user != null) {
            if (!uService.userTempPassIsValid(user)) {
                uService.setTempPassword(user.getId(), generateTempPass());
                user = uService.findOne(user.getId());
            }
            double min = (System.currentTimeMillis() - user.getCreateTempPassword().getTime())/60000;
            String msg = "Pass: " + user.getTempPassword() + " дійсний ще " + (5.0-min) + " хв.";
            model.addAttribute("msgPlaceInIndex", msg);
        }
//        makeContent(model, r.getRequestURI());
        return "index";
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

//    private void makeContent(Model model, String uri){
//
//        if (list == null) {
//            list = new ArrayList<>();
//            for (int i = 1; i < elemNum + 1; i++)
//                list.add("Content " + i);
//        }
//
//        model.addAttribute("title", "Index page");
//        model.addAttribute("contentTitle", "Печатки для ФОП");
//        switch (uri){
//            case "/toFirstPage":
//                if (pageNum > 1) pageNum = 1;
//                break;
//            case "/prevPage":
//                if (pageNum > 1) pageNum--;
//                break;
//            case "/nextPage":
//                if (pageNum * inPage < list.size()) pageNum++;
//                break;
//            case "/toLastPage":
//                if (pageNum * inPage < list.size())
//                    pageNum = (int)Math.ceil((double)list.size() / inPage);
//                break;
//        }
//
//        boolean lastPage = inPage*pageNum >= list.size();
//
//        model.addAttribute("pageNum", pageNum);
//        model.addAttribute("lastPage", lastPage);
//
//        List<String> listOut = list.subList(
//                inPage*(pageNum-1),
//                (inPage*(pageNum-1)+inPage) > list.size()
//                        ?list.size():(inPage*(pageNum-1)+inPage));
//        model.addAttribute("list", listOut );
//    }
}