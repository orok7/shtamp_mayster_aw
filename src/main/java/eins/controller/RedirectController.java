package eins.controller;

import eins.entity.User;
import eins.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/main")
public class RedirectController {

    @GetMapping("/index")
    public String index(@CookieValue(value = "loggedUserId", defaultValue = "-1")
                        int loggedUserId, @RequestParam(required = false) String logoutingModDisplay,
                        Model model) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println(loggedUserId);
        logoutingModDisplay = (logoutingModDisplay==null)?"none":logoutingModDisplay;
        model.addAttribute("logoutingModDisplay", logoutingModDisplay);

        if (loggedUserId != -1) {
//            String userName = "";
//            User user = uService.findOne(loggedUserId);
//            if (user.getIsCompany()) userName = user.getCompanyDate().getShortName();
//            else userName = user.getIndividualDate().getName() + " " + user.getIndividualDate().getSurname();
//            model.addAttribute("loggedUserName", userName);
        } else {
            System.out.println("Nobody logged");
        }

        return "index";
    }

    ///////////////////////////////////////////////////////////////////



    @Autowired
    private UserService uService;



    ///////////////////////////////////////////////////////////////////



    @ModelAttribute("loggedUser") public User loggedUser() { return new User(); }

    @ModelAttribute("passrecUser") public User passrecUser() { return new User(); }

    @ModelAttribute("regUser") public User regUser() { return new User(); }

}